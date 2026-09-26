package cn.mcmod.sakura.item.group;

import cn.mcmod.sakura.utils.ResourceLocationUtil;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public enum SakuraNormalSet {
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
    NOODLE_SOUP("noodle_soup"),

    VANILLA_SEEDS("vanilla_seeds"),
    VANILLA("vanilla"),
    GREEN_PEPPERCORN("green_peppercorn"),
    RED_PEPPERCORN("red_peppercorn"),
    BLACK_PEPPER("black_pepper"),
    WHITE_PEPPER("white_pepper"),

    EARL_GREY_LEAVES("earl_grey_leaves"),
    BLACK_TEA_LEAVES("black_tea_leaves"),
    GREEN_TEA_LEAVES("green_tea_leaves"),
    FRUIT_TEA_LEAVES("fruit_tea_leaves"),
    RICE_TEA_LEAVES("rice_tea_leaves"),
    MINT_TEA_LEAVES("mint_tea_leaves"),
    MOCHA("mocha"),

    RAW_RAMEN("raw_ramen"),
    RAW_UDON("raw_udon"),
    RAW_SOBA("raw_soba"),
    RAW_PASTA("raw_pasta"),
    CURRY_POWDER("curry_powder"),
    CURRY_SAUCE("curry_sauce"),
    WHITE_SAUCE("white_sauce"),
    VANILLA_ROAST("vanilla_roast"),
    CHESTNUT("chestnut"),
    SEAWEED("seaweed"),
    HOP("hop"),
    MINT("mint"),
    MAPLE_SYRUP("maple_syrup"),
    COIN("coin"),
    ZUKU("zuku"),
    ZUKU_INGOT("zuku_ingot"),
    SAGEGANE("sagegane"),
    TAMAHAGANE("tamahagane"),
    STEEL_INGOT("steel_ingot"),
    BENTO_BOX("bento_box"),
    SILK("silk"),
    WORCESTER_SAUCE("worcester_sauce"),
    MAYO("mayo"),
    VINEGAR("vinegar"),
    DRIED_IMOGARA("dried_imogara"),
    IMOGARANAWA("imogaranawa"),
    IMOGARANAWA_PIECE("imogaranawa_piece"),
    MISO_BALL("miso_ball"),
    ;

    private final String name;

    SakuraNormalSet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Item getItem(SakuraNormalSet set) {
        String name = set.getName();
        ResourceLocation rl = ResourceLocationUtil.item(name);
        return Registry.ITEM.get(rl);
    }
}
