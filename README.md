# Assignment 2: Factory Method & Abstract Factory

## Applied Clean Code Principles

### 1. Meaningful and Intention-Revealing Names
* **Principle:** Class, method, and variable names should clearly express their intent without requiring comments.
* **In Code:** Interfaces like `PizzaIngredientFactory`, `Dough`, `Sauce` and concrete classes like `NYPizzaIngredientFactory`, `ThinCrustDough` explicitly describe their purpose in the domain.

```java
// BEFORE (Vague naming)
public interface Factory {
    Object createA();
    Object createB();
}

// AFTER (Intention-revealing)
public interface PizzaIngredientFactory {
    Dough createDough();
    Sauce createSauce();
}
```

2. Single Responsibility Principle (SRP) / Small, Focused Classes
Principle: A class should have one, and only one, reason to change.

In Code: Creation logic is completely separated from business logic. PizzaStore manages ordering and preparation, while PizzaIngredientFactory handles raw ingredient instantiation.
```java
// BEFORE (God Object handling everything)
public class Pizza {
    public void prepare() {
        if (type.equals("NY")) {
            dough = new ThinCrustDough();
            sauce = new MarinaraSauce();
        }
    }
}

// AFTER (Separated creation responsibility)
public class CheesePizza extends Pizza {
    private final PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
    }
}
```

3. Small Methods Doing One Thing
Principle: Methods should be small and execute a single step of an algorithm.

In Code: The orderPizza method handles the workflow steps cleanly, delegating creation to createPizza().
```java
// BEFORE (Long method mixing steps)
public Pizza orderPizza(String type) {
    Pizza pizza = null;
    if (type.equals("cheese")) pizza = new CheesePizza();
    // 50 lines of cooking, cutting, boxing...
    return pizza;
}

// AFTER (Small, single-purpose methods)
public Pizza orderPizza(String type) {
    Pizza pizza = createPizza(type);
    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();
    return pizza;
}
```

4. Dependency Inversion Principle (DIP) / Dependency Injection
Principle: High-level modules should not depend on low-level modules. Both should depend on abstractions.

In Code: Pizza subclasses depend on the abstract PizzaIngredientFactory interface passed via the constructor, rather than instantiating concrete ingredient classes directly using new.
```java
// BEFORE (Tight coupling)
public class NYCheesePizza extends Pizza {
    public void prepare() {
        this.dough = new ThinCrustDough();
    }
}

// AFTER (Dependency Injection via constructor)
public abstract class Pizza {
    protected Dough dough;
    protected PizzaIngredientFactory ingredientFactory;

    public Pizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }
}
```
5. No Magic Strings / Magic Numbers
Principle: Replace raw literals with named constants or structured types to prevent typos and ensure maintainability.

In Code: Domain types and parameters use descriptive string variables/enums or specific methods instead of hardcoded magic values inside ingredient allocation logic.
```java
// BEFORE (Magic Strings)
if (style == 1) {
    // NY style
}

// AFTER (Meaningful abstractions / Encapsulated Types)
PizzaStore nyStore = new NYPizzaStore();
nyStore.orderPizza("cheese");'''
