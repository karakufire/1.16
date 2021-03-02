package cofh.lib.util.constants;

public class NBTTags {

    private NBTTags() {

    }

    public static final String TAG_ACCESSIBLE = "Accessible";
    public static final String TAG_ACTIVE = "Active";
    public static final String TAG_ACTIVE_TRACK = "WasActive";
    public static final String TAG_AMOUNT = "Amount";
    public static final String TAG_AMOUNT_IN = "AmountIn";
    public static final String TAG_AMOUNT_OUT = "AmountOut";
    public static final String TAG_ARROW_DATA = "ArrowData";
    public static final String TAG_ARROWS = "Arrows";
    public static final String TAG_AUGMENTS = "Augments";
    public static final String TAG_AUGMENT_DATA = "AugmentData";
    public static final String TAG_BLOCK_ENTITY = "BlockEntityTag";
    public static final String TAG_BLOCK_STATE = "BlockStateTag";
    public static final String TAG_BOOST_AMP = "BoostAmp";
    public static final String TAG_BOOST_CYCLES = "BoostCycles";
    public static final String TAG_BOOST_DUR = "BoostDur";
    public static final String TAG_BOOST_MAX = "BoostMax";
    public static final String TAG_BOOST_MULT = "BoostMult";
    public static final String TAG_CART_DATA = "CartData";
    public static final String TAG_CAPACITY = "Capacity";
    public static final String TAG_COLORS = "Colors";
    public static final String TAG_COOLANT = "Coolant";
    public static final String TAG_COOLANT_MAX = "CoolantMax";
    public static final String TAG_CREATIVE = "Creative";
    public static final String TAG_ENCHANTMENTS = "Enchantments";
    public static final String TAG_ENTITY = "EntityTag";
    public static final String TAG_ENERGY = "Energy";
    public static final String TAG_ENERGY_MAX = "EnergyMax";
    public static final String TAG_ENERGY_RECV = "EnergyRecv";
    public static final String TAG_ENERGY_SEND = "EnergySend";
    public static final String TAG_FACING = "Facing";
    public static final String TAG_FILTER = "Filter";
    public static final String TAG_FILTER_OPT_LIST = "AllowList";
    public static final String TAG_FILTER_OPT_NBT = "CheckNBT";
    public static final String TAG_FILTER_OPT_TAG = "CheckTag";
    public static final String TAG_FILTER_TYPE = "FilterType";
    public static final String TAG_FLUID = "Fluid";
    public static final String TAG_FLUID_NAME = "FluidName";
    public static final String TAG_FUEL = "Fuel";
    public static final String TAG_FUEL_MAX = "FuelMax";
    public static final String TAG_FUSE = "Fuse";
    public static final String TAG_INDEX = "Index";
    public static final String TAG_INSTANT = "Instant";
    public static final String TAG_ITEM_INV = "ItemInv";
    public static final String TAG_MODE = "Mode";
    public static final String TAG_NAME = "Name";
    public static final String TAG_ORIGIN = "Origin";
    public static final String TAG_POTION = "Potion";
    public static final String TAG_PRIMED = "Primed";
    public static final String TAG_PROCESS = "Proc";
    public static final String TAG_PROCESS_MAX = "ProcMax";
    public static final String TAG_PROCESS_TICK = "ProcTick";
    public static final String TAG_RENDER_FLUID = "RenderFluid";
    public static final String TAG_SECURE = "Secure";
    public static final String TAG_SETTINGS = "Settings";
    public static final String TAG_SKULL_OWNER = "SkullOwner";
    public static final String TAG_SIDES = "Sides";
    public static final String TAG_SIZE = "Size";
    public static final String TAG_SLOT = "Slot";
    public static final String TAG_SLOTS = "Slots";
    public static final String TAG_STORED_ENCHANTMENTS = "StoredEnchantments";
    public static final String TAG_TANK = "Tank";
    public static final String TAG_TANKS = "Tanks";
    public static final String TAG_TANK_INV = "TankInv";
    public static final String TAG_TIMER = "Timer";
    public static final String TAG_TRACK_IN = "TrackIn";
    public static final String TAG_TRACK_OUT = "TrackOut";
    public static final String TAG_TYPE = "Type";
    public static final String TAG_UUID = "UUID";
    public static final String TAG_XP = "Xp";
    public static final String TAG_XP_MAX = "XpMax";
    public static final String TAG_XP_TIMER = "XpTimer";

    public static final String TAG_SECURITY = "Security";
    public static final String TAG_SEC_ACCESS = "SecAccess";
    public static final String TAG_SEC_OWNER_NAME = "SecName";
    public static final String TAG_SEC_OWNER_UUID = "SecUUID";

    public static final String TAG_RS_CONTROL = "RSControl";
    public static final String TAG_RS_MODE = "RSMode";
    public static final String TAG_RS_POWER = "RSPower";
    public static final String TAG_RS_THRESHOLD = "RSThreshold";

    public static final String TAG_XFER = "Xfer";
    public static final String TAG_XFER_IN = "XferIn";
    public static final String TAG_XFER_OUT = "XferOut";

    // Compatibility
    public static final String TAG_DEMAGNETIZE_COMPAT = "AllowMachineRemoteMovement";
    public static final String TAG_CONVEYOR_COMPAT = "PreventRemoteMovement";

    // region AUGMENTS
    public static final String TAG_PROPERTIES = "Properties";

    // Types
    public static final String TAG_AUGMENT_TYPE_UPGRADE = "UpgAug";
    public static final String TAG_AUGMENT_TYPE_RF = "RFAug";
    public static final String TAG_AUGMENT_TYPE_FLUID = "FlAug";
    public static final String TAG_AUGMENT_TYPE_MACHINE = "MchAug";
    public static final String TAG_AUGMENT_TYPE_DYNAMO = "DynAug";
    public static final String TAG_AUGMENT_TYPE_AREA_EFFECT = "AEAug";
    public static final String TAG_AUGMENT_TYPE_FILTER = "FilAug";
    public static final String TAG_AUGMENT_TYPE_POTION = "PotAug";

    // General
    public static final String TAG_AUGMENT_BASE_MOD = "BaseMod";

    public static final String TAG_AUGMENT_RF_CREATIVE = "RFCre";
    public static final String TAG_AUGMENT_RF_STORAGE = "RFMax";
    public static final String TAG_AUGMENT_RF_XFER = "RFXfer";

    public static final String TAG_AUGMENT_FLUID_CREATIVE = "FlCre";
    public static final String TAG_AUGMENT_FLUID_STORAGE = "FlMax";

    public static final String TAG_AUGMENT_ITEM_CREATIVE = "ItmCre";
    public static final String TAG_AUGMENT_ITEM_STORAGE = "ItmMax";

    public static final String TAG_AUGMENT_DEPTH = "Depth";
    public static final String TAG_AUGMENT_HARVEST_LEVEL = "Harvest";
    public static final String TAG_AUGMENT_RADIUS = "Radius";
    public static final String TAG_AUGMENT_REACH = "Reach";

    public static final String TAG_AUGMENT_FEATURE_CYCLE_PROCESS = "CycProc";
    public static final String TAG_AUGMENT_FEATURE_RS_CONTROL = "RSCtl";
    public static final String TAG_AUGMENT_FEATURE_SIDE_CONFIG = "SideCfg";
    public static final String TAG_AUGMENT_FEATURE_XP_STORAGE = "XpStr";

    public static final String TAG_AUGMENT_POTION_AMPLIFIER = "PotAmp";
    public static final String TAG_AUGMENT_POTION_DURATION = "PotDur";

    // Dynamo-Specific
    public static final String TAG_AUGMENT_DYNAMO_COIL = "DynCoil";
    public static final String TAG_AUGMENT_DYNAMO_ENERGY = "DynEn";
    public static final String TAG_AUGMENT_DYNAMO_POWER = "DynPwr";
    public static final String TAG_AUGMENT_DYNAMO_THROTTLE = "DynThr";

    // Machine-Specific
    public static final String TAG_AUGMENT_MACHINE_MIN_OUTPUT = "MchMin";
    public static final String TAG_AUGMENT_MACHINE_PRIMARY = "MchPri";
    public static final String TAG_AUGMENT_MACHINE_SECONDARY = "MchSec";

    public static final String TAG_AUGMENT_MACHINE_CATALYST = "MchCat";
    public static final String TAG_AUGMENT_MACHINE_ENERGY = "MchEn";
    public static final String TAG_AUGMENT_MACHINE_POWER = "MchPwr";
    public static final String TAG_AUGMENT_MACHINE_SPEED = "MchSpd";
    public static final String TAG_AUGMENT_MACHINE_XP = "MchXp";
    // endregion
}
