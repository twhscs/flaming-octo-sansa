package io.github.twhscs.game;

import io.github.twhscs.game.util.Direction;
import org.jsfml.graphics.*;

class NonPlayableCharacter extends Character {

    NonPlayableCharacter(Texture npcTexture, int TILE_SIZE, int ANIMATION_FRAMES, int ANIMATION_SPEED) {
        super(npcTexture, TILE_SIZE, ANIMATION_FRAMES, ANIMATION_SPEED);
        updateSprite();
    }

    @Override
    public String toString() {
        return "NonPlayableCharacter{" +
                "SPRITE_SIZE=" + SPRITE_SIZE +
                ", ANIMATION_FRAMES=" + ANIMATION_FRAMES +
                ", ANIMATION_SPEED=" + ANIMATION_SPEED +
                ", ANIMATION_STEP=" + ANIMATION_STEP +
                ", position=" + position +
                ", direction=" + direction +
                ", animationFrame=" + animationFrame +
                ", animating=" + animating +
                '}';
    }

    public void randomlyChooseMove() {
        if ((int)(Math.random() * 10) == 1) {
            for (int i = 0; i < 10; i++) {
                Direction newDirection = Direction.getRandomCardinalDirection();
                if (nextPositionIsValid(newDirection)) {
                    this.move(newDirection);
                }
            }
        }
    }

    @Override
    public void update() {
        //This randomly chooses when and where to move
        //We will hopefully replace this with path finding or something more advanced
        randomlyChooseMove();
        super.update();
    }
}
