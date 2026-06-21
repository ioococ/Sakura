package cn.mcmod.sakura.item.enums;

public enum SakuraNormalItemSet {
    BAMBOO_LUMBER("bamboo_lumber"),
    SAKURA_LUMBER("sakura_lumber"),
    MAPLE_LUMBER("maple_lumber"),
    STRAW("straw"),
    CHARCOAL_POWDER("charcoal_powder"),
    SALT("salt"),
    ALKALINE("alkaline"),
    IMOGARA("imogara"),
    BROWN_RICE("brown_rice"),
    RICE("rice"),
    FLOUR("flour"),
    BUCKWHEAT_FLOUR("buckwheat_flour"),
    RICE_FLOUR("rice_flour"),
    DOUGH("dough"),
    BUCKWHEAT_DOUGH("buckwheat_dough"),
    RICE_DOUGH("rice_dough"),
    KOUJI("kouji"),
    SOYSAUCE("soysauce"),
    DASHI("dashi"),
    MISO("miso"),
    MIRIN("mirin"),
    SAKE_KASU("sake_kasu"),
    TEMPURA_BATTER("tempura_batter"),
    MOLASSES("molasses"),
    YEAST("yeast"),
    KAESHI("kaeshi"),
    NOODLE_SOUP("noodle_soup"),;
    private final String name;
    private SakuraNormalItemSet(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
