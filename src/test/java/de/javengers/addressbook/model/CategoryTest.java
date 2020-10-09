package de.javengers.addressbook.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CategoryTest {

    @Test
    void testGetterSetter(){
        Category category = new Category();

        category.setId(1L);
        category.setName("Category Name");

        assertThat(category.getId()).isEqualTo(1);
        assertThat(category.getName()).isEqualTo("Category Name");
    }


    @Test
    void testConstructor(){
        Category category = new Category(1L, "Category Name");

        assertThat(category.getId()).isEqualTo(1);
        assertThat(category.getName()).isEqualTo("Category Name");
    }

}
