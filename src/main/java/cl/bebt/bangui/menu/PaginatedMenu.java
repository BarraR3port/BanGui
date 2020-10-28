package cl.bebt.bangui.menu;

public abstract class PaginatedMenu extends Menu {

    protected int page = 0;

    protected int maxItemsPerPage = 28;

    protected int index = 0;

    public PaginatedMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    public void addMenuBorder() {
        inventory.setItem(48, back());

        inventory.setItem(49, close());

        inventory.setItem(50, next());

        for (int i = 0; i < 10; i++) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i, super.redPanel());
            }
        }
        inventory.setItem(17, super.redPanel());
        inventory.setItem(18, super.redPanel());
        inventory.setItem(26, super.redPanel());
        inventory.setItem(27, super.redPanel());
        inventory.setItem(35, super.redPanel());
        inventory.setItem(36, super.redPanel());

        for (int i = 44; i < 54; i++) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i, super.redPanel());
            }
        }
    }

    public int getMaxItemsPerPage() {
        return maxItemsPerPage;
    }
}

