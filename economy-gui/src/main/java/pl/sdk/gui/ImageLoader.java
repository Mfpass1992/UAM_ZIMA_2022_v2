package pl.sdk.gui;

import javafx.scene.image.Image;

public class ImageLoader
{

    public static Image loadCreature( String filename )
    {
        try {
            return new Image( "creatures/"+filename+".png" );
        } catch( Exception e ) {
            return new Image( "creatures/missing_creature_image.png" );
        }
    }

    public static Image loadHero( String filename )
    {
        try {
            return new Image( "heroes/"+filename+".png" );
        } catch( Exception e ) {
            return new Image( "heroes/missing_hero_image.png" );
        }
    }

}
