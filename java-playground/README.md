# Java Playground

Single Maven project for **Core Java** and **Advanced Java** practice — one package per topic.

## Package Layout

```
src/main/java/com/lab/
├── fundamentals/          ← Phase 1: Core Java (52 packages)
│   ├── variables/
│   ├── datatypes/
│   ├── operators/
│   ├── typecasting/
│   ├── io/
│   ├── ifstatement/
│   ├── switchstatement/
│   ├── loops/
│   ├── arrays/
│   ├── strings/
│   ├── classes/
│   ├── objects/
│   ├── constructors/
│   ├── methods/
│   ├── accessmodifiers/
│   ├── encapsulation/
│   ├── inheritance/
│   ├── polymorphism/
│   ├── abstraction/
│   ├── interfaces/
│   ├── abstractclasses/
│   ├── packagesdemo/
│   ├── statickeyword/
│   ├── finalkeyword/
│   ├── trycatch/
│   ├── throwthrows/
│   ├── customexception/
│   ├── arraylist/
│   ├── linkedlist/
│   ├── vector/
│   ├── hashset/
│   ├── linkedhashset/
│   ├── treeset/
│   ├── queue/
│   ├── priorityqueue/
│   ├── deque/
│   ├── stack/
│   ├── hashmap/
│   ├── linkedhashmap/
│   ├── treemap/
│   ├── hashtable/
│   ├── concurrenthashmap/
│   ├── generics/
│   ├── wildcards/
│   ├── lambda/
│   ├── functionalinterface/
│   ├── streams/
│   ├── optional/
│   ├── methodreference/
│   └── datetime/
│
└── advanced/              ← Phase 2: Advanced Java (38 packages)
    ├── thread/
    ├── runnable/
    ├── callable/
    ├── executorservice/
    ├── completablefuture/
    ├── synchronization/
    ├── locks/
    ├── volatilekeyword/
    ├── atomicclasses/
    ├── concurrentcollections/
    ├── threadpool/
    ├── jvmarchitecture/
    ├── classloader/
    ├── heapmemory/
    ├── stackmemory/
    ├── metaspace/
    ├── garbagecollection/
    ├── jvmtuning/
    ├── memoryleaks/
    ├── singleton/
    ├── factory/
    ├── builder/
    ├── adapter/
    ├── decorator/
    ├── proxy/
    ├── strategy/
    ├── observer/
    ├── command/
    ├── templatemethod/
    ├── chainofresponsibility/
    ├── servlet/
    ├── jsp/
    ├── sessionmanagement/
    ├── filters/
    ├── listeners/
    ├── junit/
    ├── mockito/
    ├── integrationtesting/
    ├── testcontainers/
    └── logging/
```

## How to Practice

Each package contains a `*Demo.java` class with a `main` method. Open the topic package and add your code.

**Examples with starter code:**
- `com.lab.fundamentals.loops.LoopsDemo`
- `com.lab.fundamentals.arrays.ArraysDemo`
- `com.lab.fundamentals.methods.MethodsDemo`
- `com.lab.fundamentals.variables.VariablesDemo`
- `com.lab.fundamentals.hashmap.HashMapDemo`

## Run in IntelliJ

1. Open `java-playground/pom.xml` as Maven project
2. Navigate to any `*Demo.java`
3. Right-click → **Run**

## Run from Terminal

```bash
cd java-playground
mvn exec:java -Dexec.mainClass="com.lab.fundamentals.loops.LoopsDemo"
mvn exec:java -Dexec.mainClass="com.lab.advanced.thread.ThreadDemo"
mvn test
```

## Naming Convention

| Item | Pattern | Example |
|------|---------|---------|
| Package | `com.lab.fundamentals.<topic>` | `com.lab.fundamentals.loops` |
| Class | `<Topic>Demo.java` | `LoopsDemo.java` |
| Advanced | `com.lab.advanced.<topic>` | `com.lab.advanced.executorservice` |

Add exercises and interview notes in [01-java-fundamentals/](../01-java-fundamentals/) and [02-java-advanced/](../02-java-advanced/).
