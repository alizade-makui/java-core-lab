# Identity, Equality and HashCode Concepts

This file summarizes the experiments from `IdentityEqualityLab`
and `HashCollectionEqualityLab`.

---

## `identityExperiment()`

### Object Identity and `==`

For reference types, `==` checks whether two references point to the exact same object.

```java
Payment payment1 = new Payment(100);
Payment payment2 = new Payment(100);
Payment payment3 = payment1;
```

Mental model:

```text
payment1 -----> Object A
payment2 -----> Object B
payment3 -----> Object A
```

Therefore:

```text
payment1 == payment2 -> false
payment1 == payment3 -> true
```

Important:
- `==` does not compare business fields.
- Same state does not mean same object.

---

## `defaultEqualsExperiment()`

### Default `equals()`

If a class does not override `equals()`, it inherits `Object.equals()`.

The default implementation behaves based on object identity.

```java
Payment payment1 = new Payment(100);
Payment payment2 = new Payment(100);
Payment payment3 = payment1;
```

Result:

```text
payment1.equals(payment2) -> false
payment1.equals(payment3) -> true
```

Important:
- Default `equals()` does not automatically compare fields.
- Business equality must be defined explicitly.

---

## `overriddenEqualsExperiment()`

Class used:

`PaymentWithEquals`

### Logical Equality

`equals()` can be overridden to define logical or business equality.

In this experiment, two payments are equal when their `amount` values are equal.

```text
same amount      -> equals() = true
different amount -> equals() = false
```

Example:

```text
payment1 == payment2      -> false
payment1.equals(payment2) -> true
```

The objects are different instances, but logically equal.

---

## `equalsReflexiveExperiment()`

### Reflexive

For any non-null object `x`:

```text
x.equals(x) must be true
```

An object must always be equal to itself.

The check:

```java
if (this == obj) {
    return true;
}
```

provides a fast path for this case.

---

## `equalsSymmetricExperiment()`

### Symmetric

For any non-null objects `x` and `y`:

```text
if x.equals(y) is true,
then y.equals(x) must also be true
```

Equality must work in both directions.

---

## `equalsTransitiveExperiment()`

### Transitive

For any non-null objects `x`, `y`, and `z`:

```text
if x.equals(y) is true
and y.equals(z) is true
then x.equals(z) must also be true
```

Equality must remain valid across a chain of equal objects.

---

## `equalsConsistencyExperiment()`

### Consistent

If the information used by `equals()` does not change,
repeated calls must return the same result.

```text
same relevant state
        ->
same equals() result
```

If an equality-related field changes, the result of `equals()` is allowed to change.

Example:

```text
p1.amount = 100
p2.amount = 100

p1.equals(p2) -> true

p2.amount = 900

p1.equals(p2) -> false
```

This is not a consistency violation because the relevant state changed.

---

## `equalsNullExperiment()`

### Null Comparison

For any non-null object `x`:

```text
x.equals(null) must be false
```

An object must never be equal to `null`.

---

## `hashCodeWithoutOverrideExperiment()`

Class used:

`PaymentWithEquals`

### `equals()` Without `hashCode()`

`equals()` and `hashCode()` are separate methods.

Overriding `equals()` does not automatically update `hashCode()`.

Important contract:

```text
if x.equals(y) == true
then x.hashCode() == y.hashCode()
```

The reverse is not required because hash collisions are possible.

Important:
- If `equals()` is overridden, `hashCode()` should also be overridden consistently.
- Equal objects must return the same hash code.

---

## `equalsAndHashCodeExperiment()`

Class used:

`PaymentWithEqualsAndHashCode`

### Consistent `equals()` and `hashCode()`

The fields used by `equals()` and `hashCode()` must be compatible.

In this experiment both are based on `amount`.

Expected behavior:

```text
p1.equals(p2)                  -> true
p1.hashCode() == p2.hashCode() -> true
```

Important:

```text
equals == true
    =>
same hashCode
```

But:

```text
same hashCode
```

does not always mean:

```text
equals == true
```

because collisions are possible.

---

## `brokenHashSetExperiment()`

Class used:

`PaymentWithEquals`

### HashSet With Broken `equals/hashCode` Contract

`HashSet` uses `hashCode()` before `equals()`.

Mental model:

```text
object
  ->
hashCode()
  ->
bucket
  ->
equals()
```

If two logically equal objects have different hash codes,
they may be placed in different buckets.

This can lead to behavior like:

```text
p1.equals(p2) -> true
set size      -> 2
```

Important:
- `equals()` alone is not enough for hash-based collections.
- `equals()` and `hashCode()` must follow the contract together.

---

## `brokenHashSetExperiment2()`

### Observing the Problem

This experiment prints both hash codes to make the problem visible.

Example:

```text
p3.equals(p4) -> true

p3.hashCode() -> different value
p4.hashCode() -> different value

set size -> 2
```

The objects are logically equal, but the `HashSet` may treat them as different
because their hash codes are not consistent with `equals()`.

---

## `correctHashSetExperiment()`

Class used:

`PaymentWithEqualsAndHashCode`

### Correct HashSet Behavior

When `equals()` and `hashCode()` are implemented consistently:

```text
p5.equals(p6)                  -> true
p5.hashCode() == p6.hashCode() -> true
set size                       -> 1
```

`HashSet` recognizes the second object as logically equal
and does not add it as a duplicate.

---

## `mutableHashCodeExperiment()`

### Mutable Fields Used in `hashCode()`

If a field used by `hashCode()` changes after the object is added to a `HashSet`,
the object's hash code may change.

Example:

```text
add object with amount = 100
        ->
object stored using hash H1

change amount to 200
        ->
hashCode becomes H2
```

The object is still physically inside the set,
but lookup may use a different bucket.

Possible result:

```text
contains before mutation -> true
contains after mutation  -> false
set size                 -> 1
```

Important:
- The object was not removed.
- The lookup path changed because the hash code changed.
- Fields used in `equals()` / `hashCode()` should be treated carefully
  while an object is stored in hash-based collections.
