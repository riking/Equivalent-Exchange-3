package com.pahimar.ee3.client.renderer;

import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.pahimar.ee3.lib.Sprites;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ItemAlchemicalChestRenderer implements IItemRenderer {
    
    private ModelChest modelChest;
    
    public ItemAlchemicalChestRenderer() {
        
        modelChest = new ModelChest();
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {

        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {

        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

        switch (type) {
            case ENTITY: {
                renderAlchemicalChest(-0.5F, 0F, -0.5F);
                break;
            }
            case EQUIPPED: {
                renderAlchemicalChest(0F, 0.4F, 0F);
                break;
            }
            case INVENTORY: {
                renderAlchemicalChest(1F, 0.65F, 1F);
                break;
            }
            default:
                break;
        }
    }

    private void renderAlchemicalChest(float x, float y, float z) {

        Tessellator tesselator = Tessellator.instance;
        ForgeHooksClient.bindTexture(Sprites.MODEL_ALCHEMICAL_CHEST, 0);
        GL11.glPushMatrix(); //start
        GL11.glTranslatef(x, y, z); //size
        //alchemicalChestModel.render(0.0625F);
        GL11.glPopMatrix(); //end
    }
}
