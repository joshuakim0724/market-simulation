package com.example;

public class RestaurantJsonString {

    public static final String BREAKFAST_RESTAURANT = "{\n" +
            "  \"money\": 200,\n" +
            "  \"time\" :\n" +
            "  {\n" +
            "    \"hours\" : 0,\n" +
            "    \"minutes\" : 0,\n" +
            "    \"day\" : 0\n" +
            "  },\n" +
            "  \"menu\" :\n" +
            "  {\n" +
            "    \"foodList\" : []\n" +
            "  },\n" +
            "\n" +
            "  \"market\" :\n" +
            "  {\n" +
            "    \"foodAvailable\" :\n" +
            "    [\n" +
            "      {\n" +
            "        \"foodName\" : \"Bacon\",\n" +
            "        \"foodValue\" : \".50\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"foodName\" : \"BaconOmelette\",\n" +
            "        \"foodValue\" : \"6\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"foodName\" : \"Bread\",\n" +
            "        \"foodValue\" : \".50\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"foodName\" : \"BreakfastPotatoes\",\n" +
            "        \"foodValue\" : \"3\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"foodName\" : \"Cheese\",\n" +
            "        \"foodValue\" : \".5\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"foodName\" : \"CookedBacon\",\n" +
            "        \"foodValue\" : \"3\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"foodName\" : \"Egg\",\n" +
            "        \"foodValue\" : \".50\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"foodName\" : \"EggsAndToast\",\n" +
            "        \"foodValue\" : \"5\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"foodName\" : \"GrilledCheese\",\n" +
            "        \"foodValue\" : \"4\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"foodName\" : \"HashBrowns\",\n" +
            "        \"foodValue\" : \"3\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"foodName\" : \"Potato\",\n" +
            "        \"foodValue\" : \".50\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"foodName\" : \"Spinach\",\n" +
            "        \"foodValue\" : \".50\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"foodName\" : \"SpinachOmelette\",\n" +
            "        \"foodValue\" : \"6\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"equipmentAvailable\" :\n" +
            "    [\n" +
            "      {\n" +
            "        \"equipmentName\" : \"Fryer\",\n" +
            "        \"equipmentValue\" : 50,\n" +
            "        \"upkeepValue\" : 2\n" +
            "      },\n" +
            "      {\n" +
            "        \"equipmentName\" : \"FryingPan\",\n" +
            "        \"equipmentValue\" : 30,\n" +
            "        \"upkeepValue\" : 1.5\n" +
            "      },\n" +
            "      {\n" +
            "        \"equipmentName\" : \"Oven\",\n" +
            "        \"equipmentValue\" : 100,\n" +
            "        \"upkeepValue\" : 4\n" +
            "      },\n" +
            "      {\n" +
            "        \"equipmentName\" : \"Toaster\",\n" +
            "        \"equipmentValue\" : 25,\n" +
            "        \"upkeepValue\" : 1\n" +
            "      }\n" +
            "    ],\n" +
            "    \"recipeAvailable\" :\n" +
            "    [\n" +
            "      {\n" +
            "        \"recipeName\" : \"BaconOmeletteRecipe\",\n" +
            "        \"ingredientList\" : [\"Bacon\", \"Egg\"],\n" +
            "        \"equipmentList\" : [\"FryingPan\"],\n" +
            "        \"recipeValue\" : 5.00,\n" +
            "        \"timeRequired\" : 15,\n" +
            "        \"outputFood\" :\n" +
            "        {\n" +
            "          \"foodName\" : \"BaconOmelette\",\n" +
            "          \"foodValue\" : \"6\"\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"recipeName\" : \"BreakfastPotatoesRecipe\",\n" +
            "        \"ingredientList\" : [\"Bacon\", \"Egg\"],\n" +
            "        \"equipmentList\" : [\"FryingPan\"],\n" +
            "        \"recipeValue\" : 3.00,\n" +
            "        \"timeRequired\" : 5,\n" +
            "        \"outputFood\" :\n" +
            "        {\n" +
            "          \"foodName\" : \"BreakfastPotatoes\",\n" +
            "          \"foodValue\" : 5\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"recipeName\" : \"CookedBaconRecipe\",\n" +
            "        \"ingredientList\" : [\"Bacon\"],\n" +
            "        \"equipmentList\" : [\"FryingPan\"],\n" +
            "        \"recipeValue\" : 3.00,\n" +
            "        \"timeRequired\" : 5,\n" +
            "        \"outputFood\" :\n" +
            "        {\n" +
            "          \"foodName\" : \"CookedBacon\",\n" +
            "          \"foodValue\" : 3\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"recipeName\" : \"EggsAndToastRecipe\",\n" +
            "        \"ingredientList\" : [\"Egg\", \"Bread\"],\n" +
            "        \"equipmentList\" : [\"FryingPan\",\"Toaster\"],\n" +
            "        \"recipeValue\" : 5.00,\n" +
            "        \"timeRequired\" : 12,\n" +
            "        \"outputFood\" :\n" +
            "        {\n" +
            "          \"foodName\" : \"EggsAndToast\",\n" +
            "          \"foodValue\" : 5\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"recipeName\" : \"GrilledCheeseRecipe\",\n" +
            "        \"ingredientList\" : [\"Cheese\", \"Bread\"],\n" +
            "        \"equipmentList\" : [\"FryingPan\"],\n" +
            "        \"recipeValue\" : 4.00,\n" +
            "        \"timeRequired\" : 10,\n" +
            "        \"outputFood\" :\n" +
            "        {\n" +
            "          \"foodName\" : \"GrilledCheese\",\n" +
            "          \"foodValue\" : 4\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"recipeName\" : \"HashBrownsRecipe\",\n" +
            "        \"ingredientList\" : [\"Potato\"],\n" +
            "        \"equipmentList\" : [\"Fryer\"],\n" +
            "        \"recipeValue\" : 3.00,\n" +
            "        \"timeRequired\" : 5,\n" +
            "        \"outputFood\" :\n" +
            "        {\n" +
            "          \"foodName\" : \"HashBrowns\",\n" +
            "          \"foodValue\" : 3\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"recipeName\" : \"SpinachOmeletteRecipe\",\n" +
            "        \"ingredientList\" : [\"Egg\", \"Spinach\"],\n" +
            "        \"equipmentList\" : [\"FryingPan\"],\n" +
            "        \"recipeValue\" : 5.00,\n" +
            "        \"timeRequired\" : 15,\n" +
            "        \"outputFood\" :\n" +
            "        {\n" +
            "          \"foodName\" : \"SpinachOmelette\",\n" +
            "          \"foodValue\" : 6\n" +
            "        }\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}";
}