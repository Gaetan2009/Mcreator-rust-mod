package net.mcreator.rust.network;

@EventBusSubscriber
public record CodeaButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<CodeaButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(RustMod.MODID, "codea_buttons"));

	public static final StreamCodec<RegistryFriendlyByteBuf, CodeaButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, CodeaButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new CodeaButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<CodeaButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final CodeaButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> handleButtonAction(context.player(), message.buttonID, message.x, message.y, message.z)).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();

		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;

	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		RustMod.addNetworkMessage(CodeaButtonMessage.TYPE, CodeaButtonMessage.STREAM_CODEC, CodeaButtonMessage::handleData);
	}

}