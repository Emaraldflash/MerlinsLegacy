package mods.MerlinsLegacy.common;
//TODO Edit sprite Entity Attack 4 for all but the BLue sprite
import mods.MerlinsLegacy.common.Armor.ItemBootsBlue;
import mods.MerlinsLegacy.common.Armor.ItemBootsGreen;
import mods.MerlinsLegacy.common.Armor.ItemBootsPurple;
import mods.MerlinsLegacy.common.Armor.ItemBootsRed;
import mods.MerlinsLegacy.common.Armor.ItemBootsYellow;
import mods.MerlinsLegacy.common.Armor.ItemDragoniteGem;
import mods.MerlinsLegacy.common.Armor.ItemElementium;
import mods.MerlinsLegacy.common.Armor.ItemElementiumBlue;
import mods.MerlinsLegacy.common.Armor.ItemElementiumGreen;
import mods.MerlinsLegacy.common.Armor.ItemElementiumPurple;
import mods.MerlinsLegacy.common.Armor.ItemElementiumRed;
import mods.MerlinsLegacy.common.Armor.ItemElementiumYellow;
import mods.MerlinsLegacy.common.Armor.ItemHelmetBlue;
import mods.MerlinsLegacy.common.Armor.ItemHelmetGreen;
import mods.MerlinsLegacy.common.Armor.ItemHelmetPurple;
import mods.MerlinsLegacy.common.Armor.ItemHelmetRed;
import mods.MerlinsLegacy.common.Armor.ItemHelmetYellow;
import mods.MerlinsLegacy.common.Armor.ItemLegsBlue;
import mods.MerlinsLegacy.common.Armor.ItemLegsGreen;
import mods.MerlinsLegacy.common.Armor.ItemLegsPurple;
import mods.MerlinsLegacy.common.Armor.ItemLegsRed;
import mods.MerlinsLegacy.common.Armor.ItemLegsYellow;
import mods.MerlinsLegacy.common.Armor.ItemPlateBlue;
import mods.MerlinsLegacy.common.Armor.ItemPlateGreen;
import mods.MerlinsLegacy.common.Armor.ItemPlatePurple;
import mods.MerlinsLegacy.common.Armor.ItemPlateRed;
import mods.MerlinsLegacy.common.Armor.ItemPlateYellow;
import mods.MerlinsLegacy.common.Blocks.BLockConstructorB;
import mods.MerlinsLegacy.common.Blocks.BLockConstructorG;
import mods.MerlinsLegacy.common.Blocks.BLockConstructorR;
import mods.MerlinsLegacy.common.Blocks.BLockConstructorY;
import mods.MerlinsLegacy.common.Blocks.BlockConstructor;
import mods.MerlinsLegacy.common.Blocks.BlockDragoniteOre;
import mods.MerlinsLegacy.common.Blocks.BlockElementiumOre;
import mods.MerlinsLegacy.common.Items.ItemBsoul;
import mods.MerlinsLegacy.common.Items.ItemGsoul;
import mods.MerlinsLegacy.common.Items.ItemRsoul;
import mods.MerlinsLegacy.common.Items.ItemYsoul;
import mods.MerlinsLegacy.common.mob.entity.EntitySpriteB;
import mods.MerlinsLegacy.common.mob.entity.EntitySpriteG;
import mods.MerlinsLegacy.common.mob.entity.EntitySpriteR;
import mods.MerlinsLegacy.common.mob.entity.EntitySpriteY;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.BlockObsidian;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.inventory.SlotCrafting;
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

@Mod(modid = "MerlinsLegacy" , name = "MerlinsLegacy" , version = "Alpha")
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
	public static Item Rsoul;
	public static Item Bsoul;
	public static Item Gsoul;
	public static Item Ysoul;
	
	//Armours
	public static Item HelmetRed;
	public static Item PlateRed;
	public static Item LegsRed;
	public static Item BootsRed;
	
	public static Item HelmetBlue;
	public static Item PlateBlue;
	public static Item LegsBlue;
	public static Item BootsBlue;
	
	public static Item HelmetGreen;
	public static Item PlateGreen;
	public static Item LegsGreen;
	public static Item BootsGreen;
	
	public static Item HelmetYellow;
	public static Item PlateYellow;
	public static Item LegsYellow;
	public static Item BootsYellow;
	
	public static Item HelmetPurple;
	public static Item PlatePurple;
	public static Item LegsPurple;
	public static Item BootsPurple;
	


	//Ores
	int ElementiumOreID ;
	int DragoniteOreID;
	//User Blocks
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
	int RsoulID;
	int BsoulID;
	int GsoulID;
	int YsoulID;
	
	//Armours
	int HelmetRedID;
	int PlateRedID;
	int LegsRedID;
	int BootsRedID;
	
	int HelmetBlueID;
	int PlateBlueID;
	int LegsBlueID;
	int BootsBlueID;
	
	int HelmetYellowID;
	int PlateYellowID;
	int LegsYellowID;
	int BootsYellowID;
	
	int HelmetGreenID;
	int PlateGreenID;
	int LegsGreenID;
	int BootsGreenID;
	
	int HelmetPurpleID;
	int PlatePurpleID;
	int LegsPurpleID;
	int BootsPurpleID;

	@PreInit
	public void preInt(FMLPreInitializationEvent event){
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();	

		//Ores
		ElementiumOreID = config.get("Block IDs","Elementium Ore ID", 500).getInt();
		DragoniteOreID = config.get("Block IDs","Dragonite Ore ID", 501).getInt();
		//User Blocs
		MagicalFurnaceID= config.get("Block IDs","Magical FurnaceID",522).getInt();
		MagicalFurnaceOnID= config.get("Block IDs","Magical FurnaceOnID",523).getInt();
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
		RsoulID = config.get("Block IDs","Fire Elemental Soul ID", 517).getInt();
		BsoulID = config.get("Block IDs","Water Elemental Soul ID", 518).getInt();
		GsoulID = config.get("Block IDs","Earth Elemental Soul ID", 519).getInt();
		YsoulID = config.get("Block IDs","Air Elemental Soul ID", 520).getInt();
		//Armours
		HelmetRedID = config.get("Block IDs","Helmet Red ID", 540).getInt();
		PlateRedID = config.get("Block IDs","Helmet Red ID", 541).getInt();
		LegsRedID = config.get("Block IDs","Helmet Red ID", 542).getInt();
		BootsRedID = config.get("Block IDs","Helmet Red ID", 543).getInt();
		
		HelmetBlueID = config.get("Block IDs","Helmet Blue ID", 544).getInt();
		PlateBlueID = config.get("Block IDs","Helmet Blue ID", 545).getInt();
		LegsBlueID = config.get("Block IDs","Helmet Blue ID", 546).getInt();
		BootsBlueID = config.get("Block IDs","Helmet Blue ID", 547).getInt();
		
		HelmetGreenID = config.get("Block IDs","Helmet Green ID", 548).getInt();
		PlateGreenID = config.get("Block IDs","Helmet Green ID", 549).getInt();
		LegsGreenID = config.get("Block IDs","Helmet Green ID", 550).getInt();
		BootsGreenID = config.get("Block IDs","Helmet Green ID", 551).getInt();
		
		HelmetYellowID = config.get("Block IDs","Helmet Yellow ID", 552).getInt();
		PlateYellowID = config.get("Block IDs","Helmet Yellow ID", 553).getInt();
		LegsYellowID = config.get("Block IDs","Helmet Yellow ID", 554).getInt();
		BootsYellowID = config.get("Block IDs","Helmet Yellow ID", 555).getInt();
		
		HelmetPurpleID = config.get("Block IDs","Helmet Purple ID", 556).getInt();
		PlatePurpleID = config.get("Block IDs","Helmet Purple ID", 557).getInt();
		LegsPurpleID = config.get("Block IDs","Helmet Purple ID", 558).getInt();
		BootsPurpleID = config.get("Block IDs","Helmet Purple ID", 559).getInt();

		

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
		MagicalFurnace = (new BlockMagicalFurnace(522, false)).setHardness(3.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("MagicalFurnace").setCreativeTab(MerlinsLegacy.tabMerlinsLegacy);
		MagicalFurnaceOn = (new BlockMagicalFurnace(523, true)).setHardness(3.5F).setStepSound(Block.soundStoneFootstep).setLightValue(0.875F).setUnlocalizedName("MagicalFurnac");
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
		Rsoul = new ItemRsoul (RsoulID).setUnlocalizedName("Fire Elemental Soul");
		Bsoul = new ItemBsoul (BsoulID).setUnlocalizedName("Water Elemental Soul");
		Gsoul = new ItemGsoul (GsoulID).setUnlocalizedName("Earth Elemental Soul");
		Ysoul = new ItemYsoul (YsoulID).setUnlocalizedName("Air Elemental Soul");

		
		//Armor Render
		int renderRedArmor = proxy.addArmor("Red");
		int renderBlueArmor = proxy.addArmor("Blue");
		int renderGreenArmor = proxy.addArmor("Green");
		int renderYellowArmor = proxy.addArmor("Yellow");
		int renderPurpleArmor = proxy.addArmor("Purple");
		
		proxy.registerRenderers();


		//Armour
		HelmetRed = new ItemHelmetRed(540, EnumArmorMaterial.DIAMOND, renderRedArmor , 0).setUnlocalizedName("HelmetRed");
		PlateRed =  new ItemPlateRed(541, EnumArmorMaterial.DIAMOND, renderRedArmor, 1).setUnlocalizedName("PlateRed");
		LegsRed = new ItemLegsRed(542, EnumArmorMaterial.DIAMOND, renderRedArmor, 2).setUnlocalizedName("LegsRed");
		BootsRed = new ItemBootsRed(543, EnumArmorMaterial.DIAMOND, renderRedArmor, 3).setUnlocalizedName("BootsRed");
		
		HelmetBlue = new ItemHelmetBlue(544, EnumArmorMaterial.DIAMOND, renderBlueArmor , 0).setUnlocalizedName("HelmetBlue");
		PlateBlue =  new ItemPlateBlue(545, EnumArmorMaterial.DIAMOND, renderBlueArmor, 1).setUnlocalizedName("PlateBlue");
		LegsBlue = new ItemLegsBlue(546, EnumArmorMaterial.DIAMOND, renderBlueArmor, 2).setUnlocalizedName("LegsBlue");
		BootsBlue = new ItemBootsBlue(547, EnumArmorMaterial.DIAMOND, renderBlueArmor, 3).setUnlocalizedName("BootsBlue");
		
		HelmetGreen = new ItemHelmetGreen(548, EnumArmorMaterial.DIAMOND, renderGreenArmor , 0).setUnlocalizedName("HelmetGreen");
		PlateGreen =  new ItemPlateGreen(549, EnumArmorMaterial.DIAMOND, renderGreenArmor, 1).setUnlocalizedName("PlateGreen");
		LegsGreen = new ItemLegsGreen(550, EnumArmorMaterial.DIAMOND, renderGreenArmor, 2).setUnlocalizedName("LegsGreen");
		BootsGreen = new ItemBootsGreen(551, EnumArmorMaterial.DIAMOND, renderGreenArmor, 3).setUnlocalizedName("BootsGreen");
		
		HelmetYellow = new ItemHelmetYellow(552, EnumArmorMaterial.DIAMOND, renderYellowArmor , 0).setUnlocalizedName("HelmetYellow");
		PlateYellow =  new ItemPlateYellow(553, EnumArmorMaterial.DIAMOND, renderYellowArmor, 1).setUnlocalizedName("PlateYellow");
		LegsYellow = new ItemLegsYellow(554, EnumArmorMaterial.DIAMOND, renderYellowArmor, 2).setUnlocalizedName("LegsYellow");
		BootsYellow = new ItemBootsYellow(555, EnumArmorMaterial.DIAMOND, renderYellowArmor, 3).setUnlocalizedName("BootsYellow");
		
		HelmetPurple = new ItemHelmetPurple(556, EnumArmorMaterial.DIAMOND, renderPurpleArmor , 0).setUnlocalizedName("HelmetPurple");
		PlatePurple =  new ItemPlatePurple(557, EnumArmorMaterial.DIAMOND, renderPurpleArmor, 1).setUnlocalizedName("PlatePurple");
		LegsPurple = new ItemLegsPurple(558, EnumArmorMaterial.DIAMOND, renderPurpleArmor, 2).setUnlocalizedName("LegsPurple");
		BootsPurple = new ItemBootsPurple(559, EnumArmorMaterial.DIAMOND, renderPurpleArmor, 3).setUnlocalizedName("BootsPurple");
		
		
		
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
		GameRegistry.addRecipe(new ItemStack(MagicalFurnace, 1), new Object[]{"CCC", "CRC", "CCC", 'C', Constructor, 'R', ElementiumRed});
		GameRegistry.addRecipe(new ItemStack(Crafting, 1), new Object[]{"CCC", "CRC", "CCC", 'C', Constructor, 'R', ElementiumGreen});

		GameRegistry.addRecipe(new ItemStack(Constructor, 8), new Object[]{"DXD", "XXX", "DXD", 'X', Block.obsidian, 'D', ElementiumDull});
		GameRegistry.addRecipe(new ItemStack(ConstructorR, 2), new Object[]{"DXD", "XXX", "DXD", 'X', Constructor, 'D', ElementiumRed});
		GameRegistry.addRecipe(new ItemStack(ConstructorB, 2), new Object[]{"DXD", "XXX", "DXD", 'X', Constructor, 'D', ElementiumBlue});
		GameRegistry.addRecipe(new ItemStack(ConstructorY, 2), new Object[]{"DXD", "XXX", "DXD", 'X', Constructor, 'D', ElementiumYellow});
		GameRegistry.addRecipe(new ItemStack(ConstructorG, 2), new Object[]{"DXD", "XXX", "DXD", 'X', Constructor, 'D', ElementiumGreen});
		
		GameRegistry.addRecipe(new ItemStack(ElementiumRed, 1), new Object[]{" X ", "XDX", " X ", 'X', Rsoul, 'D', ElementiumDull});
		GameRegistry.addRecipe(new ItemStack(ElementiumBlue, 1), new Object[]{" X ", "XDX", " X ", 'X', Bsoul, 'D', ElementiumDull});
		GameRegistry.addRecipe(new ItemStack(ElementiumGreen, 1), new Object[]{" X ", "XDX", " X ", 'X', Gsoul, 'D', ElementiumDull});
		GameRegistry.addRecipe(new ItemStack(ElementiumYellow, 1), new Object[]{" X ", "XDX", " X ", 'X', Ysoul, 'D', ElementiumDull});



	}
	private static void gameRegisters(){
		//Ores
		GameRegistry.registerBlock(ElementiumOre, "Elementium Ore");
		GameRegistry.registerBlock(DragoniteOre, "Dragonite Ore");
		MinecraftForge.setBlockHarvestLevel(DragoniteOre, "pickaxe", 2);

		//User Blocks
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
		GameRegistry.registerItem(Rsoul, "Fire Elemental Soul");
		GameRegistry.registerItem(Bsoul, "Water Elemental Soul");
		GameRegistry.registerItem(Gsoul, "Earth Elemental Soul");
		GameRegistry.registerItem(Ysoul, "Air Elemental Soul");

		//Armours
		GameRegistry.registerItem(HelmetRed, "Helmet Of Fire");
		GameRegistry.registerItem(PlateRed, "Plate Of Fire");
		GameRegistry.registerItem(LegsRed, "Legs Of Fire");
		GameRegistry.registerItem(BootsRed, "Boots Of Fire");
		
		GameRegistry.registerItem(HelmetBlue, "Helmet Of Water");
		GameRegistry.registerItem(PlateBlue, "Plate Of Water");
		GameRegistry.registerItem(LegsBlue, "Legs Of Water");
		GameRegistry.registerItem(BootsBlue, "Boots Of Water");
		
		GameRegistry.registerItem(HelmetGreen, "Helmet Of Earth");
		GameRegistry.registerItem(PlateGreen, "Plate Of Earth");
		GameRegistry.registerItem(LegsGreen, "Legs Of Earth");
		GameRegistry.registerItem(BootsGreen, "Boots Of Earth");
		
		GameRegistry.registerItem(HelmetYellow, "Helmet Of Air");
		GameRegistry.registerItem(PlateYellow, "Plate Of Air");
		GameRegistry.registerItem(LegsYellow, "Legs Of Air");
		GameRegistry.registerItem(BootsYellow, "Boots Of Air");
		
		GameRegistry.registerItem(HelmetPurple, "Helmet Of Pure Magic");
		GameRegistry.registerItem(PlatePurple, "Plate Of Pure Magic");
		GameRegistry.registerItem(LegsPurple, "Legs Of Pure Magic");
		GameRegistry.registerItem(BootsPurple, "Boots Of Pure Magic");


	}

	private static void languageRegisters(){
		//Ores
		LanguageRegistry.addName(ElementiumOre, "Elementium Ore");
		LanguageRegistry.addName(DragoniteOre, "DragoniteOre");
		//User Blocks
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
		LanguageRegistry.addName(Rsoul, "Fire Elemental Soul");
		LanguageRegistry.addName(Bsoul, "Water Elemental Soul");
		LanguageRegistry.addName(Gsoul, "Earth Elemental Soul");
		LanguageRegistry.addName(Ysoul, "Air Elemental Soul");
		//Armours
		LanguageRegistry.addName(HelmetRed, "Helmet Of Fire");
		LanguageRegistry.addName(PlateRed, "Plate Of Fire");
		LanguageRegistry.addName(LegsRed, "Legs Of Fire");
		LanguageRegistry.addName(BootsRed, "Boots Of Fire");
		
		LanguageRegistry.addName(HelmetBlue, "Helmet Of Water");
		LanguageRegistry.addName(PlateBlue, "Plate Of Water");
		LanguageRegistry.addName(LegsBlue, "Legs Of Water");
		LanguageRegistry.addName(BootsBlue, "Boots Of Water");
		
		LanguageRegistry.addName(HelmetGreen, "Helmet Of Earth");
		LanguageRegistry.addName(PlateGreen, "Plate Of Earth");
		LanguageRegistry.addName(LegsGreen, "Legs Of Earth");
		LanguageRegistry.addName(BootsGreen, "Boots Of Earth");
		
		LanguageRegistry.addName(HelmetYellow, "Helmet Of Air");
		LanguageRegistry.addName(PlateYellow, "Plate Of Air");
		LanguageRegistry.addName(LegsYellow, "Legs Of Air");
		LanguageRegistry.addName(BootsYellow, "Boots Of Air");
		
		LanguageRegistry.addName(HelmetPurple, "Helmet Of Pure Magic");
		LanguageRegistry.addName(PlatePurple, "Plate Of Pure Magic");
		LanguageRegistry.addName(LegsPurple, "Legs Of Pure Magic");
		LanguageRegistry.addName(BootsPurple, "Boots Of Pure Magic");
		

		LanguageRegistry.instance().addStringLocalization("Merlins Legacy", "en_US", "Merlins Legacy");


		//Entity Elemental Spites
		EntityRegistry.registerModEntity(EntitySpriteR.class, "RedSprite", 1, instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntitySpriteB.class, "BlueSprite", 2, instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntitySpriteG.class, "GreenSprite", 3, instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntitySpriteY.class, "YellowSprite", 4, instance, 80, 3, true);
	
		EntityRegistry.addSpawn(EntitySpriteR.class, 10, 2, 4, EnumCreatureType.monster, BiomeGenBase.plains);
		EntityRegistry.addSpawn(EntitySpriteB.class, 10, 2, 4, EnumCreatureType.monster, BiomeGenBase.plains);
		EntityRegistry.addSpawn(EntitySpriteG.class, 10, 2, 4, EnumCreatureType.monster, BiomeGenBase.plains);
		EntityRegistry.addSpawn(EntitySpriteY.class, 10, 2, 4, EnumCreatureType.monster, BiomeGenBase.plains);


		LanguageRegistry.instance().addStringLocalization("entity.MerlinsLegacy.RedSprite.name", "Fire Elemental");
		LanguageRegistry.instance().addStringLocalization("entity.MerlinsLegacy.BlueSprite.name", "Water Elemental");
		LanguageRegistry.instance().addStringLocalization("entity.MerlinsLegacy.GreenSprite.name", "Earth Elemental");
		LanguageRegistry.instance().addStringLocalization("entity.MerlinsLegacy.YellowSprite.name", "Air Elemental");
		
		 registerEntityEgg(EntitySpriteR.class, 0xFC0303, 0x7D2F2F);
		 registerEntityEgg(EntitySpriteB.class, 0x00FBFF, 0x0058FC);
		 registerEntityEgg(EntitySpriteG.class, 0x2AFC05, 0x33BF1B);
		 registerEntityEgg(EntitySpriteY.class, 0xF5ED05, 0xE8E005);
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