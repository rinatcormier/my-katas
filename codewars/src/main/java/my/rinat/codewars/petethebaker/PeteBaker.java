package my.rinat.codewars.petethebaker;

import java.util.Map;

public class PeteBaker {
  public static int cakes(Map<String, Integer> recipe, Map<String, Integer> available) {
    int maxCakes = Integer.MAX_VALUE;
    for (Map.Entry<String, Integer> recipeItem : recipe.entrySet()) {
      if (!available.containsKey(recipeItem.getKey())) {
        maxCakes = 0;
        break;
      }
      final var availableCakeCount = available.get(recipeItem.getKey()) / recipe.get(recipeItem.getKey());
      if (availableCakeCount < maxCakes) {
        maxCakes = availableCakeCount;
      }
    }
    return maxCakes;
  }
}