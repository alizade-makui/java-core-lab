# Object Model Concepts

This file is updated step by step as new experiments are added to `ObjectReferenceLab`.

## `mutationExperiment()`
- Multiple references can point to the same object.
- Mutating the object through one reference is visible through the others.

## `reassignmentExperiment()`
- Reassigning a reference does not mutate the old object.
- The reference variable starts pointing to a different object.

## `nullReferenceExperiment()`
- `null` belongs to a reference, not to an object.
- Setting one reference to `null` does not destroy the object if another reachable reference still exists.

## `unreachableObjectExperiment()`
- When an object is no longer reachable, it becomes eligible for garbage collection.
- Unreachable does not mean immediately removed from memory.

## `parameterPassingExperiment()`
- Java is always pass-by-value.
- For objects, the copied value is the reference value.
- Mutating the shared object is visible to the caller.
- Reassigning the local parameter does not change the caller's reference variable.

## `primitiveParameterExperiment()`
- Primitive values are copied when passed to a method.
- Changing the method parameter does not change the caller's primitive variable.

## `stackHeapExperiment()`
- Simplified mental model:
  - local primitive values live in the method stack frame
  - local reference variables live in the method stack frame
  - objects are normally considered to live on the heap
- Different stack frames can contain different references to the same heap object.

## `lifetimeExperiment()`
- A local variable can disappear when a method returns while the object stays reachable.
- Object lifetime is not the same as method lifetime.

## `earlyUnreachableExperiment()`
- An object can become unreachable before the current method finishes.
- Reachability, not method completion, determines GC eligibility.
