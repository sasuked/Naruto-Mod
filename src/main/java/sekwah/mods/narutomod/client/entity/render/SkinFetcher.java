package sekwah.mods.narutomod.client.entity.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ImageBufferDownload;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;

public class SkinFetcher {

    public static final ResourceLocation locationStevePng = new ResourceLocation("textures/entity/steve.png");

    public static ResourceLocation getLocationSkin(String par0Str) {
        return new ResourceLocation("skins/" + StringUtils.stripControlCodes(par0Str));
    }

    public static ResourceLocation getLocationCape(String par0Str) {
        return new ResourceLocation("cloaks/" + StringUtils.stripControlCodes(par0Str));
    }

    public static ThreadDownloadImageData getDownloadImageSkin(ResourceLocation p_110304_0_, String p_110304_1_) {
        TextureManager texturemanager = Minecraft.getMinecraft().getTextureManager();
        Object object = texturemanager.getTexture(p_110304_0_);

        if (object == null) {
            object = new ThreadDownloadImageData(null, String.format("http://skins.minecraft.net/MinecraftSkins/%s.png", StringUtils.stripControlCodes(p_110304_1_)), locationStevePng, new ImageBufferDownload());
            texturemanager.loadTexture(p_110304_0_, (ITextureObject) object);
        }

        return (ThreadDownloadImageData) object;
    }

    public static ThreadDownloadImageData getDownloadImageCape(ResourceLocation p_110304_0_, String p_110304_1_) {
        TextureManager texturemanager = Minecraft.getMinecraft().getTextureManager();
        Object object = texturemanager.getTexture(p_110304_0_);

        if (object == null) {
            object = new ThreadDownloadImageData(null, String.format("http://skins.minecraft.net/MinecraftCloaks/%s.png", StringUtils.stripControlCodes(p_110304_1_)), locationStevePng, new ImageBufferDownload());
            texturemanager.loadTexture(p_110304_0_, (ITextureObject) object);
        }

        return (ThreadDownloadImageData) object;
    }
}
