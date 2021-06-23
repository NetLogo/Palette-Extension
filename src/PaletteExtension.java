import org.nlogo.api.DefaultClassManager;
import org.nlogo.api.PrimitiveManager;

public class PaletteExtension extends DefaultClassManager {
    public void load(PrimitiveManager primitiveManager) {
    	//Scale gradient for only 2 colors is in the process of being depreciated
        //primitiveManager.addPrimitive ("scale-gradient", new ScaleGradient());
        primitiveManager.addPrimitive ("scale-gradient", new ScaleGradient());
        primitiveManager.addPrimitive ("scale-scheme", new ScaleScheme());
        primitiveManager.addPrimitive ("scheme-colors", new SchemeColors());
        primitiveManager.addPrimitive ("scheme-dialog", new SchemeDialog());
        //alpha
        primitiveManager.addPrimitive ("extract-alpha", new ExtractAlpha());
        primitiveManager.addPrimitive ("alpha-updated", new AlphaUpdated());
        primitiveManager.addPrimitive ("get-color-alpha", new GetColorAlpha());
        primitiveManager.addPrimitive ("set-color-alpha", new SetColorAlpha());
        primitiveManager.addPrimitive ("adjust-color-alpha", new AdjustColorAlpha());
        //HSB
        primitiveManager.addPrimitive ("extract-hue", new ExtractHue());
        primitiveManager.addPrimitive ("extract-saturation", new ExtractSaturation());
        primitiveManager.addPrimitive ("extract-brightness", new ExtractBrightness());

        primitiveManager.addPrimitive ("hue-updated", new HueUpdated());
        primitiveManager.addPrimitive ("saturation-updated", new SaturationUpdated());
        primitiveManager.addPrimitive ("brightness-updated", new BrightnessUpdated());

        primitiveManager.addPrimitive ("adjust-color-hue", new AdjustColorHue());
        primitiveManager.addPrimitive ("adjust-color-saturation", new AdjustColorSaturation());
        primitiveManager.addPrimitive ("adjust-color-brightness", new AdjustColorBrightness());
    }
}
