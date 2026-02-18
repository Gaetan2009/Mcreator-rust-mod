// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelmodel_grenade_f1_Converted<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "model_grenade_f1_converted"), "main");
	private final ModelPart bande6;
	private final ModelPart bande;
	private final ModelPart bande5;
	private final ModelPart bande8;
	private final ModelPart bande3;
	private final ModelPart bande4;
	private final ModelPart bande7;
	private final ModelPart bande2;
	private final ModelPart group;

	public Modelmodel_grenade_f1_Converted(ModelPart root) {
		this.bande6 = root.getChild("bande6");
		this.bande = this.bande6.getChild("bande");
		this.bande5 = this.bande6.getChild("bande5");
		this.bande8 = this.bande6.getChild("bande8");
		this.bande3 = this.bande6.getChild("bande3");
		this.bande4 = this.bande6.getChild("bande4");
		this.bande7 = this.bande6.getChild("bande7");
		this.bande2 = this.bande6.getChild("bande2");
		this.group = root.getChild("group");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bande6 = partdefinition.addOrReplaceChild("bande6", CubeListBuilder.create(),
				PartPose.offset(0.0F, 16.0F, 0.0F));

		PartDefinition cube_r1 = bande6.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(4, 5)
						.addBox(-1.5F, 3.5F, -0.75F, 0.5F, 0.5F, 1.5F, new CubeDeformation(0.0F)).texOffs(2, 4)
						.addBox(-1.5F, 2.5F, -0.75F, 0.5F, 0.5F, 1.5F, new CubeDeformation(0.0F)).texOffs(1, 3)
						.addBox(-1.5F, 1.5F, -0.75F, 0.5F, 0.5F, 1.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 3.5F, 0.0F, 0.0F, 2.3562F, 0.0F));

		PartDefinition bande = bande6.addOrReplaceChild("bande",
				CubeListBuilder.create().texOffs(0, 2)
						.addBox(1.0F, 6.5F, -0.75F, 0.5F, 0.5F, 1.5F, new CubeDeformation(0.0F)).texOffs(4, 5)
						.addBox(1.0F, 5.5F, -0.75F, 0.5F, 0.5F, 1.5F, new CubeDeformation(0.0F)).texOffs(6, 6)
						.addBox(1.0F, 4.5F, -0.75F, 0.5F, 0.5F, 1.5F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bande5 = bande6.addOrReplaceChild("bande5", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r2 = bande5.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(6, 8)
						.addBox(-1.5F, 3.5F, -0.75F, 0.5F, 0.5F, 1.5F, new CubeDeformation(0.0F)).texOffs(5, 7).mirror()
						.addBox(-1.5F, 2.5F, -0.75F, 0.5F, 0.5F, 1.5F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(6, 6).addBox(-1.5F, 1.5F, -0.75F, 0.5F, 0.5F, 1.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 3.5F, 0.0F, 0.0F, -2.3562F, 0.0F));

		PartDefinition bande8 = bande6.addOrReplaceChild("bande8", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r3 = bande8.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(5, 9).mirror()
				.addBox(-1.5F, 3.5F, -0.75F, 0.5F, 0.5F, 1.5F, new CubeDeformation(0.0F)).mirror(false).texOffs(8, 6)
				.addBox(-1.5F, 2.5F, -0.75F, 0.5F, 0.5F, 1.5F, new CubeDeformation(0.0F)).texOffs(5, 3).mirror()
				.addBox(-1.5F, 1.5F, -0.75F, 0.5F, 0.5F, 1.5F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 3.5F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition bande3 = bande6.addOrReplaceChild("bande3", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r4 = bande3.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(4, 10)
						.addBox(-1.5F, 3.5F, -0.75F, 0.5F, 0.5F, 1.5F, new CubeDeformation(0.0F)).texOffs(4, 10)
						.mirror().addBox(-1.5F, 2.5F, -0.75F, 0.5F, 0.5F, 1.5F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(6, 7).addBox(-1.5F, 1.5F, -0.75F, 0.5F, 0.5F, 1.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 3.5F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition bande4 = bande6.addOrReplaceChild("bande4", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r5 = bande4.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(5, 11).mirror()
						.addBox(-1.5F, 2.5F, -0.75F, 0.5F, 0.5F, 1.5F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(10, 11).addBox(-1.5F, 1.5F, -0.75F, 0.5F, 0.5F, 1.5F, new CubeDeformation(0.0F))
						.texOffs(10, 10).addBox(-1.5F, 0.5F, -0.75F, 0.5F, 0.5F, 1.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition bande7 = bande6.addOrReplaceChild("bande7", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r6 = bande7.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(12, 12)
						.addBox(-1.5F, 2.5F, -0.75F, 0.5F, 0.5F, 1.5F, new CubeDeformation(0.0F)).texOffs(11, 12)
						.addBox(-1.5F, 1.5F, -0.75F, 0.5F, 0.5F, 1.5F, new CubeDeformation(0.0F)).texOffs(11, 11)
						.addBox(-1.5F, 0.5F, -0.75F, 0.5F, 0.5F, 1.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition bande2 = bande6.addOrReplaceChild("bande2",
				CubeListBuilder.create().texOffs(7, 8)
						.addBox(-1.5F, 4.5F, -0.75F, 0.5F, 0.5F, 1.5F, new CubeDeformation(0.0F)).texOffs(12, 13)
						.addBox(-1.5F, 5.5F, -0.75F, 0.5F, 0.5F, 1.5F, new CubeDeformation(0.0F)).texOffs(13, 13)
						.addBox(-1.5F, 6.5F, -0.75F, 0.5F, 0.5F, 1.5F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition group = partdefinition.addOrReplaceChild("group",
				CubeListBuilder.create().texOffs(10, 0)
						.addBox(-0.5F, 2.5F, 0.0F, 1.0F, 0.5F, 2.0F, new CubeDeformation(0.0F)).texOffs(13, 0).mirror()
						.addBox(-0.5F, 3.0F, 2.0F, 1.0F, 3.0F, 0.5F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(12, 0).addBox(-0.5F, 2.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
						.texOffs(4, 8).addBox(-1.0F, 4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 16.0F, 0.0F));

		PartDefinition cube_r7 = group
				.addOrReplaceChild("cube_r7",
						CubeListBuilder.create().texOffs(2, 8).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bande6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		group.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}