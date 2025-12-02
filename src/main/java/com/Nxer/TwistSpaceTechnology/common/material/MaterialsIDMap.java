package com.Nxer.TwistSpaceTechnology.common.material;

import gregtech.GTMod;
import gregtech.api.enums.Materials;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

public class MaterialsIDMap extends Int2ObjectOpenHashMap<Materials> {

    public MaterialsIDMap() {
        // Register materials with IDs
        r(88, MaterialsTST.NeutroniumAlloy);
        r(91, MaterialsTST.AxonisAlloy);
        r(92, MaterialsTST.Axonium);
        r(94, MaterialsTST.Dubnium);

        // After registration, assign meta IDs
        register();
    }

    public void register() {
        for (int ID : this.keySet()) {
            Materials material = this.get(ID);
            if (material != null) {
                material.mMetaItemSubID = ID;
            }
        }
    }

    private void r(int ID, Materials material) {
        Materials prevMaterial = this.put(ID, material);
        if (prevMaterial != null) {
            GTMod.GT_FML_LOGGER.warn(
                "Material '{}' with ID {} was replaced by '{}'.",
                prevMaterial.mName,
                ID,
                material != null ? material.mName : "null");
        }
    }
}
