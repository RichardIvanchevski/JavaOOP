package magicGame;


import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MagicianTests  {
    private Magician magician;

    @Before
    public void setUp() {
        this.magician = new Magician("Ozz", 100);
    }

    @Test(expected = NullPointerException.class)
    public void testSetUsernameWithNull() {
        magician = new Magician(null,100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetHealthBelowZero() {
        magician = new Magician("Helius",-1);
    }

    @Test
    public void testAddMagic() {
        Magic magic1 = new Magic("Iris", 12);
        Magic magic2 = new Magic("Sabrina", 50);

        this.magician.addMagic(magic1);
        this.magician.addMagic(magic2);

        assertEquals(2, this.magician.getMagics().size());
        assertTrue(this.magician.getMagics().contains(magic1));
        assertTrue(this.magician.getMagics().contains(magic2));
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullMagic() {
        this.magician.addMagic(null);
    }

    @Test
    public void testRemoveMagic() {
        Magic magic1 = new Magic("Iris", 12);
        Magic magic2 = new Magic("Sabrina", 50);

        this.magician.addMagic(magic1);
        this.magician.addMagic(magic2);

        assertTrue(this.magician.removeMagic(magic1));
        assertEquals(1, this.magician.getMagics().size());
        assertFalse(this.magician.getMagics().contains(magic1));
    }

    @Test
    public void testGetMagic() {
        Magic magic1 = new Magic("Iris", 12);
        Magic magic2 = new Magic("Sabrina", 50);

        this.magician.addMagic(magic1);
        this.magician.addMagic(magic2);

        assertEquals(magic1, this.magician.getMagic("Iris"));
        assertEquals(magic2, this.magician.getMagic("Sabrina"));
        assertNull(this.magician.getMagic("Non-existent Magic"));
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamageWithZeroHealth() {
        this.magician.takeDamage(1000);
        this.magician.takeDamage(1000);
    }

    @Test
    public void testTakeDamage() {
        this.magician.takeDamage(50);
        assertEquals(50, this.magician.getHealth());

        this.magician.takeDamage(20);
        assertEquals(30, this.magician.getHealth());
    }
}