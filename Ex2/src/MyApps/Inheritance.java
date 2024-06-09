/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyApps;

/**
 *
 * @author Maglasang
 */
public class Inheritance {
    // Level 1: Food class (root) 

Class Food { 
    // Common properties and methods for all food items 
} 
// Level 2: Vegetable extends Food 
Class Vegetable extends Food { 
    // Properties and methods specific to vegetables 
} 
// Level 2: Fruit extends Food 

Class Fruit extends Food { 
    // Properties and methods specific to fruits 
} 
// Level 3: LeafyVegetable extends Vegetable 

Class LeafyVegetable extends Vegetable { 
    // Properties and methods specific to leafy vegetables 
} 
// Level 3: RootVegetable extends Vegetable 

Class RootVegetable extends Vegetable { 

    // Properties and methods specific to root vegetables 

} 
// Level 3: CitrusFruit extends Fruit 

Class CitrusFruit extends Fruit { 
    // Properties and methods specific to citrus fruits 
} 
// Level 3: BerryFruit extends Fruit 

Class BerryFruit extends Fruit { 
    // Properties and methods specific to berry fruits 
} 
// Level 4: Spinach extends LeafyVegetable 

Class Spinach extends LeafyVegetable { 
    // Properties and methods specific to spinach 
} 
// Level 4: Carrot extends RootVegetable 

Class Carrot extends RootVegetable { 
    // Properties and methods specific to carrots 
} 

// Level 4: Orange extends CitrusFruit 
Class Orange extends CitrusFruit { 
    // Properties and methods specific to oranges 
} 
// Level 4: Blueberry extends BerryFruit 
Class Blueberry extends BerryFruit { 
    // Properties and methods specific to blueberries 
} 
// Level 5: BabySpinach extends Spinach 

Class BabySpinach extends Spinach { 
    // Properties and methods specific to baby spinach 
} 
// Level 5: BabyCarrot extends Carrot 
Class BabyCarrot extends Carrot { 
    // Properties and methods specific to baby carrots 
} 
// Level 5: Mandarin extends Orange 
Class Mandarin extends Orange { 
    // Properties and methods specific to mandarin oranges 
}
// Level 5: WildBlueberry extends Blueberry 
Class WildBlueberry extends Blueberry { 
    // Properties and methods specific to wild blueberries 
} 

}
