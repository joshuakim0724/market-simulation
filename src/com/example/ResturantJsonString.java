package com.example;

public class ResturantJsonString {
    public static final String BREAKFAST_RESTURANT = "{\n" +
            "  \"money\": 200,\n" +
            "  \"time\" :\n" +
            "  {\n" +
            "    \"hours\" : 0,\n" +
            "    \"minutes\" : 0,\n" +
            "    \"day\" : 0\n" +
            "  },\n" +
            "  \"Menu\" : {},\n" +
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
            "        \"foodName\" : \"Bacon Omelette\",\n" +
            "        \"foodValue\" : \"6\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"foodName\" : \"Bread\",\n" +
            "        \"foodValue\" : \".50\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"foodName\" : \"Breakfast Potatoes\",\n" +
            "        \"foodValue\" : \"3\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"foodName\" : \"Cheese\",\n" +
            "        \"foodValue\" : \".5\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"foodName\" : \"Cooked Bacon\",\n" +
            "        \"foodValue\" : \"3\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"foodName\" : \"Egg\",\n" +
            "        \"foodValue\" : \".50\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"foodName\" : \"Eggs and Toast\",\n" +
            "        \"foodValue\" : \"5\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"foodName\" : \"Grilled Cheese\",\n" +
            "        \"foodValue\" : \"4\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"foodName\" : \"Hash Browns\",\n" +
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
            "        \"foodName\" : \"Spinach Omelette\",\n" +
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
            "        \"equipmentName\" : \"Frying Pan\",\n" +
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
            "        \"recipeName\" : \"Bacon Omlette Recipe\",\n" +
            "        \"ingredientList\" : [\"Bacon\", \"Egg\"],\n" +
            "        \"equipmentList\" : [\"Frying Pan\"],\n" +
            "        \"recipeValue\" : 5.00,\n" +
            "        \"timeRequired\" : 15,\n" +
            "        \"outputFood\" :\n" +
            "        {\n" +
            "          \"foodName\" : \"Bacon Omelette\",\n" +
            "          \"foodValue\" : \"6\"\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"recipeName\" : \"Breakfast Potatoes Recipe\",\n" +
            "        \"ingredientList\" : [\"Bacon\", \"Egg\"],\n" +
            "        \"equipmentList\" : [\"Frying Pan\"],\n" +
            "        \"recipeValue\" : 3.00,\n" +
            "        \"timeRequired\" : 5,\n" +
            "        \"outputFood\" :\n" +
            "        {\n" +
            "          \"foodName\" : \"Breakfast Potatoes\",\n" +
            "          \"foodValue\" : 5\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"recipeName\" : \"Cooked Bacon Recipe\",\n" +
            "        \"ingredientList\" : [\"Bacon\"],\n" +
            "        \"equipmentList\" : [\"Frying Pan\"],\n" +
            "        \"recipeValue\" : 3.00,\n" +
            "        \"timeRequired\" : 5,\n" +
            "        \"outputFood\" :\n" +
            "        {\n" +
            "          \"foodName\" : \"Cooked Bacon\",\n" +
            "          \"foodValue\" : 5\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"recipeName\" : \"Eggs and Toast Recipe\",\n" +
            "        \"ingredientList\" : [\"Egg\", \"Bread\"],\n" +
            "        \"equipmentList\" : [\"Frying Pan\",\"Toaster\"],\n" +
            "        \"recipeValue\" : 5.00,\n" +
            "        \"timeRequired\" : 12,\n" +
            "        \"outputFood\" :\n" +
            "        {\n" +
            "          \"foodName\" : \"Eggs and Toast\",\n" +
            "          \"foodValue\" : 5\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"recipeName\" : \"Grilled Cheese Recipe\",\n" +
            "        \"ingredientList\" : [\"Cheese\", \"Bread\"],\n" +
            "        \"equipmentList\" : [\"Frying Pan\"],\n" +
            "        \"recipeValue\" : 4.00,\n" +
            "        \"timeRequired\" : 10,\n" +
            "        \"outputFood\" :\n" +
            "        {\n" +
            "          \"foodName\" : \"Grilled Cheese\",\n" +
            "          \"foodValue\" : 4\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"recipeName\" : \"Hash Browns Recipe\",\n" +
            "        \"ingredientList\" : [\"Potato\"],\n" +
            "        \"equipmentList\" : [\"Fryer\"],\n" +
            "        \"recipeValue\" : 3.00,\n" +
            "        \"timeRequired\" : 5,\n" +
            "        \"outputFood\" :\n" +
            "        {\n" +
            "          \"foodName\" : \"Hash Browns\",\n" +
            "          \"foodValue\" : 3\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"recipeName\" : \"Spinach Omeltte Recipe\",\n" +
            "        \"ingredientList\" : [\"Egg\", \"Spinach\"],\n" +
            "        \"equipmentList\" : [\"Frying Pan\"],\n" +
            "        \"recipeValue\" : 5.00,\n" +
            "        \"timeRequired\" : 15,\n" +
            "        \"outputFood\" :\n" +
            "        {\n" +
            "          \"foodName\" : \"Spinach Omeltte\",\n" +
            "          \"foodValue\" : 3\n" +
            "        }\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}";
}
