package com.backelite.sonarqube.commons.profile;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class XmlProfileRulesParser {

    public static final class ProfileRule {
        private final String repositoryKey;
        private final String ruleKey;

        public ProfileRule(String repositoryKey, String ruleKey) {
            this.repositoryKey = repositoryKey;
            this.ruleKey = ruleKey;
        }

        public String getRepositoryKey() {
            return repositoryKey;
        }

        public String getRuleKey() {
            return ruleKey;
        }
    }

    public static List<ProfileRule> parse(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return Collections.emptyList();
        }

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(false);
            factory.setXIncludeAware(false);
            factory.setExpandEntityReferences(false);
            setFeature(factory, "http://apache.org/xml/features/disallow-doctype-decl", true);
            setFeature(factory, "http://xml.org/sax/features/external-general-entities", false);
            setFeature(factory, "http://xml.org/sax/features/external-parameter-entities", false);
            setFeature(factory, "http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputStream);
            NodeList ruleNodes = document.getElementsByTagName("rule");
            List<ProfileRule> rules = new ArrayList<>(ruleNodes.getLength());
            for (int i = 0; i < ruleNodes.getLength(); i++) {
                Node node = ruleNodes.item(i);
                if (node instanceof Element) {
                    Element ruleElement = (Element) node;
                    String repositoryKey = childText(ruleElement, "repositoryKey");
                    String ruleKey = childText(ruleElement, "key");
                    if (repositoryKey != null && ruleKey != null) {
                        rules.add(new ProfileRule(repositoryKey, ruleKey));
                    }
                }
            }
            return rules;
        } catch (ParserConfigurationException | SAXException e) {
            throw new IOException("Failed to parse profile xml", e);
        }
    }

    private static void setFeature(DocumentBuilderFactory factory, String feature, boolean value) {
        try {
            factory.setFeature(feature, value);
        } catch (ParserConfigurationException ignored) {
            // Best effort: continue with parser defaults when unsupported.
        }
    }

    private static String childText(Element element, String tagName) {
        NodeList nodes = element.getElementsByTagName(tagName);
        if (nodes.getLength() == 0) {
            return null;
        }
        String text = nodes.item(0).getTextContent();
        if (text == null) {
            return null;
        }
        text = text.trim();
        return text.isEmpty() ? null : text;
    }

    private XmlProfileRulesParser() {
    }
}
