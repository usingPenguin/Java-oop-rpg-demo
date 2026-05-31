package abilities;

public interface Attackable {
    default double getAttackDamage() {
        return 100;
    }

    void attack(Damageable target);
}
