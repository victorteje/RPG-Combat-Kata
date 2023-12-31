package org.example.characters;

public class Character {
    public int health;
    public int level;
    public boolean alive;

    public Character(int health, int level, boolean alive) {
        this.health = health;
        this.level = level;
        this.alive = alive;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    public int dealDamage(int damage){
        setHealth(getHealth() - damage);
        if(damage >= getHealth()){
            setAlive(false);
            setHealth(0);
        }
        return getHealth();
    }

    public int heal(int amountHealed){
        if(isAlive()){
        setHealth(getHealth() + amountHealed);
            if(getHealth() > 1000){
                setHealth(1000);
            }
        }
        else{
                setHealth(0);
        }

        return getHealth();
    }

//    public int dealDamage(int damage, Character character){
//        if(this != character){
//            setHealth(getHealth() - damage);
//            if(damage >= getHealth()){
//                setAlive(false);
//                setHealth(0);
//            }
//            else{
//                setHealth(this.health);
//            }
//        }
//        return getHealth();
//    }

    public int heal(int amountHealed, Character character){
        if (this != character){
            setHealth(character.health);
        }
        else {
            if(isAlive()){
                setHealth(getHealth() + amountHealed);
                if(getHealth() > 1000){
                    setHealth(1000);
                }
            }
            else{
                setHealth(0);
            }
        }
        return getHealth();
    }

    public int dealDamage(int damage, Character character){
        if(this != character){
            int attackerLevel = this.level;
            int targetLevel = character.level;
            int levelDiff = targetLevel - attackerLevel;
            if (levelDiff >= 5){
                int halfDamage = damage / 2;
                setHealth(getHealth() - halfDamage);
                if (halfDamage >= getHealth()) {
                    setAlive(false);
                    setHealth(0);
                }
                else {
                    setHealth(this.health);
                }
            }
            else if(levelDiff <= -5){
                int doubleDamage = damage * 2;
                setHealth(getHealth() - doubleDamage);
                if (doubleDamage >= getHealth()) {
                    setAlive(false);
                    setHealth(0);
                }
                else {
                    setHealth(this.health);
                }
            }
            else {
                setHealth(getHealth() - damage);
                if (damage >= getHealth()) {
                    setAlive(false);
                    setHealth(0);
                }
                else {
                    setHealth(this.health);
                }
            }
        }
        return getHealth();
    }

}