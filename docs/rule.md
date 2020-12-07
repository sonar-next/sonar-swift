
# Rule (规则)
我们在公司内部对 Infer 扫描出来了规则进行了 Review ，以下是我们正在使用的规则列表。

| 规则名                         | 问题类型 | 是否正在使用 | 优先级 |
| ------------------------------ | -------- | ------------ | ------ |
| MULTIPLE_WEAKSELF              | Bug      | 否           | 主要   |
| UNSAFE_CALL_TO_OPTIONAL_METHOD | Bug      | 是           | 主要   |
| DEAD_STORE                     | Bug      | 是           | 主要   |
| MIXED_SELF_WEAKSELF            | Bug      | 是           | 主要   |
| NULL_DEREFERENCE               | Bug      | 是           | 严重   |
| CAPTURED_STRONG_SELF           | Bug      | 是           | 主要   |
| WEAK_SELF_IN_NO_ESCAPE_BLOCK   | Bug      | 是           | 主要   |
| STRONG_SELF_NOT_CHECKED        | Bug      | 否           | 主要   |
| RETAIN_CYCLE                   | Bug      | 是           | 严重   |
| RESOURCE_LEAK                  | Bug      | 是           | 严重   |
| UNINITIALIZED_VALUE            | Bug      | 是           | 严重   |



| 规则名                             | 问题类型 | 是否正在使用 | 优先级 |
| ---------------------------------- | -------- | ------------ | ------ |
| ASSIGN_POINTER_WARNING             | 坏味道   | 否           | 主要   |
| BAD_POINTER_COMPARISON             | 坏味道   | 否           | 主要   |
| PARAMETER_NOT_NULL_CHECKED         | 坏味道   | 是           | 主要   |
| POINTER_TO_CONST_OBJC_CLASS        | 坏味道   | 否           | 主要   |
| IVAR_NOT_NULL_CHECKED              | 坏味道   | 是           | 主要   |
| POINTER_TO_INTEGRAL_IMPLICIT_CAST  | 坏味道   | 是           | 主要   |
| DIRECT_ATOMIC_PROPERTY_ACCESS      | 坏味道   | 是           | 主要   |
| STRONG_DELEGATE_WARNING            | 坏味道   | 是           | 主要   |
| PREMATURE_NIL_TERMINATION_ARGUMENT | 坏味道   | 是           | 主要   |





# Rule

We reviewed the rules scanned by Infer within the company. The following is a list of rules we are using



| Rule Key                       | Issue Type | use  | priority |
| ------------------------------ | ---------- | ---- | -------- |
| MULTIPLE_WEAKSELF              | Bug        | No   | major    |
| UNSAFE_CALL_TO_OPTIONAL_METHOD | Bug        | Yes  | major    |
| DEAD_STORE                     | Bug        | Yes  | major    |
| MIXED_SELF_WEAKSELF            | Bug        | Yes  | major    |
| NULL_DEREFERENCE               | Bug        | Yes  | critical |
| CAPTURED_STRONG_SELF           | Bug        | Yes  | major    |
| WEAK_SELF_IN_NO_ESCAPE_BLOCK   | Bug        | Yes  | major    |
| STRONG_SELF_NOT_CHECKED        | Bug        | No   | major    |
| RETAIN_CYCLE                   | Bug        | Yes  | critical |
| RESOURCE_LEAK                  | Bug        | Yes  | critical |
| UNINITIALIZED_VALUE            | Bug        | Yes  | critical |



| Rule Key                           | Issue Type | use  | priority |
| ---------------------------------- | ---------- | ---- | -------- |
| ASSIGN_POINTER_WARNING             | CodeSmell  | No   | major    |
| BAD_POINTER_COMPARISON             | CodeSmell  | No   | major     |
| PARAMETER_NOT_NULL_CHECKED         | CodeSmell  | Yes  | major     |
| POINTER_TO_CONST_OBJC_CLASS        | CodeSmell  | No   | major     |
| IVAR_NOT_NULL_CHECKED              | CodeSmell  | Yes  | major     |
| POINTER_TO_INTEGRAL_IMPLICIT_CAST  | CodeSmell  | Yes  | major     |
| DIRECT_ATOMIC_PROPERTY_ACCESS      | CodeSmell  | Yes  | major     |
| STRONG_DELEGATE_WARNING            | CodeSmell  | Yes  | major     |
| PREMATURE_NIL_TERMINATION_ARGUMENT | CodeSmell  | Yes  | major     |

