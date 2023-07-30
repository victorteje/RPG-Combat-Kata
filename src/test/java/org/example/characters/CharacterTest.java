package org.example.characters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
    Character character = new Character(1000, 1, true);
    @Test
    public void new_characters_should_have_1000_health() {

        assertTrue(character.health == 1000 && character.level == 1 && character.alive);
    }

    @Test
    public void health_should_be_reduced_by_an_equal_amount_to_the_damage_received(){
        int damage = 200;
        assertEquals(800, character.dealDamage(damage));
    }

    @Test
    public void if_damge_dealt_is_higher_than_health_then_character_should_die(){
        int damage = 1100;
        assertEquals(0, character.dealDamage(damage));
        assertFalse(character.isAlive());
    }

    @Test
    public void characters_can_heal_each_other(){
        int amountHealed = 1100;
        assertEquals(1000, character.heal(amountHealed));
    }

    @Test
    public void dead_characters_cannot_be_healed(){
        character.setAlive(false);
        int amountHealed = 1100;
        assertEquals(0, character.heal(amountHealed));
    }

    @Test
    public void characters_cannot_damage_themselves(){
        int damage = 200;
        assertEquals(1000, character.dealDamage(damage, character));
    }
}