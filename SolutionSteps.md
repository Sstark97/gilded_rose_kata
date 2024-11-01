# Solution Steps

## Code Smells
- At the beginning we find a long method, which has a lot of logic. So we have a _Long Function_. There are many conditionals, which make the code difficult to follow
- We also see _Feature Envy_, since the updateQuality method does not stop handling data from the Item class, this smells like the behavior is part of the Item.
- There are certain parts of _duplicate code_

## Steps
- The first step was to invert the conditions of the if statements, as there were many negations, and I wanted to eliminate them to facilitate method extraction.
- Next, I extracted a method for each condition that determined the type of Item.
- 🚨 IMPORTANT 🚨: The following steps are technically incorrect, as I modified the Item class, which was not allowed. However, these changes helped with the refactoring, and the Item class was later restored.
  - I extracted methods to modify the quality of items, adding or subtracting by one. These were moved to Item.
  - I extracted methods to handle the quality increase for items of type "backstage" and "aged brie."
  - I moved the methods defining the type to Item.
  - I divided the loop into three parts, as there were three distinct sections, allowing each to be addressed separately (quality increment, sellIn reduction, and quality handling after sellIn expired).
  - I transformed some loops into a more functional style.
  - I unified some conditionals to eliminate nesting.
  - I extracted additional methods and moved them to Item.
  - I separated the quality increment logic by Item type.
  - I extracted methods to avoid direct access to Item attributes.
  - I extracted methods within each loop and moved them to Item.
  - Since the behavior differed depending on the Item type, it was logical to use polymorphism to encapsulate the logic in different classes. Therefore, I created a factory method in Item and moved the relevant logic to each subclass.
- At this point, I realized I couldn’t modify Item, so I reverted it to its original state and added an interface implemented by all subclasses of Item to retain polymorphism. Then I updated GildedRose to store a list of elements from the new interface.
- Next, I cleaned up each class, extracting a few more methods and some constants.
- I extracted a class to define the constants representing the Item types.
- Once the code was clean, it was easy to add the new object required by the exercise. All that was needed was to add a new Item and include its creation in the factory.

## Used Refactors
- Extract method
- Extract constants
- Split loop
- Replace conditional with polymorphism
- Decompose conditional
- Inline method
- Convert to instance method

## Improvements
- Create a method copy of _updateQuality_, to safely change the operation, and compare the result of both methods with Approval
- Once the new method has the ideal result, call the new method in the old one and then inline it and maintain the new logic