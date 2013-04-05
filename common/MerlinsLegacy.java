package mods.MerlinsLegacy.common;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.BlockObsidian;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "MerlinsLegacy" , name = "MerlinsLegacy" , version = "1.0.0")
@NetworkMod(clientSideRequired = true , serverSideRequired = false)

public class MerlinsLegacy {

	@Instance("MerlinsLegacy")
	public static MerlinsLegacy instance;

	static int startEntityId = 560;

	public static CreativeTabs tabMerlinsLegacy = new CreativeTabs("Merlins Legacy") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Constructor, 1, 0);
		}
	};

	//ores
	public static Block  ElementiumOre;
	public static Block  DragoniteOre;
	//User Blocks
	public static Block MInfuse;
	public static Block MagicalFurnace;
	public static Block MagicalFurnaceOn;
	public static Block Crafting;
	//Constructors
	public static Block Constructor;
	public static Block ConstructorR;
	public static Block ConstructorB;
	public static Block ConstructorY;
	public static Block ConstructorG;
	//Item
	public static Item ElementiumDull;
	public static Item ElementiumRed;
	public static Item ElementiumBlue;
	public static Item ElementiumGreen;
	public static Item ElementiumYellow;
	public static Item ElementiumPurple;
	public static Item DragoniteGem;
	//Armours
	public static Item HelmetRed;
	public static Item PlateRed;
	public static Item LegsRed;
	public static Item BootsRed;


	//Ores
	int ElementiumOreID;
	int DragoniteOreID;
	//User Blocks
	int MInfuseID;
	int MagicalFurnaceID;
	int MagicalFurnaceOnID;
	int CraftingID;
	//Constructors
	int ConstructorID;
	int ConstructorRID;
	int ConstructorBID;
	int ConstructorYID;
	int ConstructorGID;
	//Items
	int ElementiumDullID;
	int ElementiumRedID;
	int ElementiumBlueID;
	int ElementiumGreenID;
	int ElementiumYellowID;
	int ElementiumPurpleID;
	int DragoniteGemID;
	//Armours
	int HelmetRedID;
	int PlateRedID;
	int LegsRedID;
	int BootsRedID;

	@PreInit
	public void preInt(FMLPreInitializationEvent event){
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();	

		//Ores
		ElementiumOreID = config.get("Block IDs","Elementium Ore ID", 500).getInt();
		DragoniteOreID = config.get("Block IDs","Dragonite Ore ID", 501).getInt();
		//User Blocs
		MInfuseID = config.get("Block IDs","MInfuse ID", 520).getInt();
		MagicalFurnaceID= config.get("Block IDs","Magical FurnaceID",521).getInt();
		MagicalFurnaceOnID= config.get("Block IDs","Magical FurnaceOnID",522).getInt();
		CraftingID = config.get("Block IDs","Crafting ID", 524).getInt();
		//Constructors
		ConstructorID = config.get("Block IDs","Constructor ID", 531).getInt();
		ConstructorRID = config.get("Block IDs","ConstructorR ID", 532).getInt();
		ConstructorBID = config.get("Block IDs","ConstructorB ID", 533).getInt();
		ConstructorYID = config.get("Block IDs","ConstructorY ID", 534).getInt();
		ConstructorGID = config.get("Block IDs","ConstructorG ID", 535).getInt();
		//Items
		ElementiumDullID = config.get("Block IDs","Elementium Dull ID", 510).getInt();
		ElementiumRedID = config.get("Block IDs","Elementium Red ID", 511).getInt();
		ElementiumBlueID = config.get("Block IDs","Elementium Blue ID", 512).getInt();
		ElementiumGreenID = config.get("Block IDs","Elementium Green ID", 513).getInt();
		ElementiumYellowID = config.get("Block IDs","Elementium Yellow ID", 514).getInt();
		ElementiumPurpleID = config.get("Block IDs"," Elementium Purple ID", 515).getInt();
		DragoniteGemID = config.get("Block IDs","Dragonite Gem ID", 516).getInt();
		//Armours
		HelmetRedID = config.get("Block IDs","Helmet Red ID", 540).getInt();
		PlateRedID = config.get("Block IDs","Helmet Red ID", 541).getInt();
		LegsRedID = config.get("Block IDs","Helmet Red ID", 542).getInt();
		BootsRedID = config.get("Block IDs","Helmet Red ID", 543).getInt();


		NetworkRegistry.instance().registerGuiHandler(this, new GuiHandlerML());
	}

	@SidedProxy(clientSide = "mods.MerlinsLegacy.client.ClientProxy", serverSide = "mods.MerlinsLegacy.common.ServerProxy")
	public static ServerProxy proxy;

	static EnumArmorMaterial MagicalArmour = EnumHelper.addArmorMaterial("MagicalArmour", 29, new int[] {2, 7, 5, 3}, 9);

	@Init
	public void load(FMLInitializationEvent event){

		//Ores
		ElementiumOre = new BlockElementiumOre(ElementiumOreID, Material.iron).setUnlocalizedName("tileElementiumOre").setLightValue(0.5f).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep);
		DragoniteOre = new BlockDragoniteOre(DragoniteOreID, Material.iron).setUnlocalizedName("tileDragoniteOre").setLightValue(0.5f).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep);
		//User Blocks
		MInfuse = new BlockMInfuse(MInfuseID, Material.iron).setUnlocalizedName("tileMInfuse").setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep);
		MagicalFurnace = (new BlockMagicalFurnace(521, false)).setHardness(3.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("MagicalFurnace").setCreativeTab(MerlinsLegacy.tabMerlinsLegacy);
		MagicalFurnaceOn = (new BlockMagicalFurnace(522, true)).setHardness(3.5F).setStepSound(Block.soundStoneFootstep).setLightValue(0.875F).setUnlocalizedName("MagicalFurnac");
		Crafting = new BlockCrafting(CraftingID).setUnlocalizedName("tileCraft").setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep);

		//Constructors
		Constructor= new BlockConstructor(ConstructorID, Material.iron).setUnlocalizedName("tileConstructor").setLightValue(0.1f).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep);
		ConstructorR= new BLockConstructorR(ConstructorRID, Material.iron).setUnlocalizedName("tileConstructorR").setLightValue(0.1f).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep);
		ConstructorB= new BLockConstructorB(ConstructorBID, Material.iron).setUnlocalizedName("tileConstructorB").setLightValue(0.1f).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep);
		ConstructorY= new BLockConstructorY(ConstructorYID, Material.iron).setUnlocalizedName("tileConstructorY").setLightValue(0.1f).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep);
		ConstructorG= new BLockConstructorG(ConstructorGID, Material.iron).setUnlocalizedName("tileConstructorG").setLightValue(0.1f).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep);

		//Items
		ElementiumDull = new ItemElementium (ElementiumDullID).setUnlocalizedName("Dull Elementium");
		ElementiumRed = new ItemElementiumRed (ElementiumRedID).setUnlocalizedName("Fire Elementium");
		ElementiumBlue = new ItemElementiumBlue (ElementiumBlueID).setUnlocalizedName("Water Elementium");
		ElementiumGreen = new ItemElementiumGreen (ElementiumGreenID).setUnlocalizedName("Earth Elementium");
		ElementiumYellow = new ItemElementiumYellow (ElementiumYellowID).setUnlocalizedName("Air Elementium");
		ElementiumPurple = new ItemElementiumPurple (ElementiumPurpleID).setUnlocalizedName("Pure Elementium");
		DragoniteGem = new ItemDragoniteGem (DragoniteGemID).setUnlocalizedName("Dragonite Gem");

		//Armor Render
		int renderRedArmor = proxy.addArmor("Red");
		
		proxy.registerRenderers();

		//Armour
		HelmetRed = (ItemArmor)(new ItemArmor(540, EnumArmorMaterial.DIAMOND, renderRedArmor, 0)).setUnlocalizedName("HelmetRed");
		PlateRed = (ItemArmor)(new ItemArmor(541, EnumArmorMaterial.DIAMOND, renderRedArmor, 1)).setUnlocalizedName("PlateRed");
		LegsRed = (ItemArmor)(new ItemArmor(542, EnumArmorMaterial.DIAMOND, renderRedArmor, 2)).setUnlocalizedName("LegsRed");
		BootsRed = (ItemArmor)(new ItemArmor(543, EnumArmorMaterial.DIAMOND, renderRedArmor, 3)).setUnlocalizedName("BootsRed");


		GameRegistry.registerTileEntity( TileEntityMFurnace.class, "Magical Furnace");

		gameRegisters();
		languageRegisters();
		craftingRecipes();

		GameRegistry.registerWorldGenerator(new WorldGeneratorMerlinsLegacy());

		GameRegistry.addSmelting(DragoniteOreID ,new ItemStack(DragoniteGem, 2), 1F);




	}
	//Crafting
	public void craftingRecipes(){


		GameRegistry.addRecipe(new ItemStack(ElementiumPurple, 1), new Object[]{"RXB", "XDX", "GXY", 'R', ElementiumRed , 'B', ElementiumBlue, 'G', ElementiumGreen , 'Y', ElementiumYellow, 'X', ElementiumDull, 'D', DragoniteGem});
		GameRegistry.addRecipe(new ItemStack(MInfuse, 1), new Object[]{"DXD", "XCX", "DXD",'C', Block.workbench , 'X', Block.obsidian, 'D', ElementiumDull});
		GameRegistry.addRecipe(new ItemStack(MagicalFurnace, 1), new Object[]{"CCC", "CRC", "CCC", 'C', Constructor, 'R', ElementiumRed});
		GameRegistry.addRecipe(new ItemStack(Crafting, 1), new Object[]{"CCC", "CRC", "CCC", 'C', Constructor, 'R', ElementiumGreen});

		GameRegistry.addRecipe(new ItemStack(Constructor, 8), new Object[]{"DXD", "XXX", "DXD", 'X', Block.obsidian, 'D', ElementiumDull});
		GameRegistry.addRecipe(new ItemStack(ConstructorR, 2), new Object[]{"DXD", "XXX", "DXD", 'X', Constructor, 'D', ElementiumRed});
		GameRegistry.addRecipe(new ItemStack(ConstructorB, 2), new Object[]{"DXD", "XXX", "DXD", 'X', Constructor, 'D', ElementiumBlue});
		GameRegistry.addRecipe(new ItemStack(ConstructorY, 2), new Object[]{"DXD", "XXX", "DXD", 'X', Constructor, 'D', ElementiumYellow});
		GameRegistry.addRecipe(new ItemStack(ConstructorG, 2), new Object[]{"DXD", "XXX", "DXD", 'X', Constructor, 'D', ElementiumGreen});


	}
	private static void gameRegisters(){
		//Ores
		GameRegistry.registerBlock(ElementiumOre, "Elementium Ore");
		GameRegistry.registerBlock(DragoniteOre, "Dragonite Ore");
		MinecraftForge.setBlockHarvestLevel(DragoniteOre, "pickaxe", 2);

		//User Blocks
		GameRegistry.registerBlock(MInfuse, "Elemental Infusor");
		GameRegistry.registerBlock(MagicalFurnace, "Magical Furnace");
		GameRegistry.registerBlock(MagicalFurnaceOn, "Magical FurnaceOn");
		GameRegistry.registerBlock(Crafting, "Magical Crafting Table");
		//Constructors
		GameRegistry.registerBlock(Constructor, "Basic Constructo");
		GameRegistry.registerBlock(ConstructorR, "Fire Constructo");
		GameRegistry.registerBlock(ConstructorB, "Water Constructor");
		GameRegistry.registerBlock(ConstructorY, "Air Constructor");
		GameRegistry.registerBlock(ConstructorG, "Earth Constructor");

		//Items
		GameRegistry.registerItem(ElementiumDull, "Dull Elementium");
		GameRegistry.registerItem(ElementiumRed, "Fire Elementium");
		GameRegistry.registerItem(ElementiumBlue, "Watter Elementium");
		GameRegistry.registerItem(ElementiumGreen, "Earth Elementium");
		GameRegistry.registerItem(ElementiumYellow, "Air Elementium");
		GameRegistry.registerItem(ElementiumPurple, "Pure Elementium");
		GameRegistry.registerItem(DragoniteGem, "Dragonite Gem");

		//Armours
		GameRegistry.registerItem(HelmetRed, "Helmet Of Fire");
		GameRegistry.registerItem(PlateRed, "Plate Of Fire");
		GameRegistry.registerItem(LegsRed, "Legs Of Fire");
		GameRegistry.registerItem(BootsRed, "Boots Of Fire");


	}

	private static void languageRegisters(){
		//Ores
		LanguageRegistry.addName(ElementiumOre, "Elementium Ore");
		LanguageRegistry.addName(DragoniteOre, "DragoniteOre");
		//User Blocks
		LanguageRegistry.addName(MInfuse, "Elemental Infusor");
		LanguageRegistry.addName(MagicalFurnace, "Magical Furnace");
		LanguageRegistry.addName(MagicalFurnaceOn, "Magical FurnaceOn");
		LanguageRegistry.addName(Crafting, "Magical Crafting Table");
		//Constructors
		LanguageRegistry.addName(Constructor, "Basic Constructor");
		LanguageRegistry.addName(ConstructorR, "Fire Constructor");
		LanguageRegistry.addName(ConstructorB, "Water Constructor");
		LanguageRegistry.addName(ConstructorY, "Air Constructor");
		LanguageRegistry.addName(ConstructorG, "Earth Constructor");
		//Items
		LanguageRegistry.addName(ElementiumDull, "Dull Elementium");
		LanguageRegistry.addName(ElementiumRed, "Fire Elementium");
		LanguageRegistry.addName(ElementiumBlue, "Water Elementium");
		LanguageRegistry.addName(ElementiumGreen, "Earth Elementium");
		LanguageRegistry.addName(ElementiumYellow, "Air Elementium");
		LanguageRegistry.addName(ElementiumPurple, "Pure Elementium");
		LanguageRegistry.addName(DragoniteGem, "Dragonite Gem");
		//Armours
		LanguageRegistry.addName(HelmetRed, "Helmet Of Fire");
		LanguageRegistry.addName(PlateRed, "Plate Of Fire");
		LanguageRegistry.addName(LegsRed, "Legs Of Fire");
		LanguageRegistry.addName(BootsRed, "Boots Of Fire");

		LanguageRegistry.instance().addStringLocalization("Merlins Legacy", "en_US", "Merlins Legacy");


		//Entity Elemental Sprites
		EntityRegistry.registerModEntity(EntitySpriteR.class, "RedSprite", 1, instance, 80, 3, true);
		//Entity Spawns
		EntityRegistry.addSpawn(EntitySpriteR.class, 10, 2, 4, EnumCreatureType.monster, BiomeGenBase.plains);


		LanguageRegistry.instance().addStringLocalization("entity.MerlinsLegacy.RedSprite.name", "Fire Elemental");
		
		 registerEntityEgg(EntitySpriteR.class, 0xffffff, 0x000000);
	} 


	public static int getUniqueEntityId(){
	
	do
	{
		startEntityId++;
	}
	while(EntityList.getStringFromID(startEntityId) != null);

	return startEntityId;
}
public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor)
{
	int id =  getUniqueEntityId();
	EntityList.IDtoClassMapping.put(id, entity);
	EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
}

}