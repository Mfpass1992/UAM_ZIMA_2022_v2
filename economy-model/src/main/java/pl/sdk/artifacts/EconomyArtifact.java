package pl.sdk.artifacts;

public class EconomyArtifact {
    private final ArtifactInfo info;
    private final int goldCost;

    EconomyArtifact(ArtifactInfo aInfo, int aGoldCost) {
        info = aInfo;
        goldCost = aGoldCost;
    }

    public int getGoldCost() {
        return goldCost;
    }

    public String getName() {
        return info.getTranslatedName();
    }

    public String getDescription() {
        return info.getDescription();
    }

    public ArtifactSlotType getSlot() {
        return info.getSlot();
    }
}
