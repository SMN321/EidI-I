import processing.core.PApplet;

import java.util.Arrays;

public class KMeansViewer extends PApplet {

    private Data data;

    private final int feature1;
    private final int feature2;

    private double[][] centers;

    public KMeansViewer(Data data, int feature1, int feature2) {
        this.data = data;
        this.feature1 = feature1;
        this.feature2 = feature2;
    }

    public void show() {

        PApplet.runSketch(new String[]{"Foo"}, this);
    }

    public void touch(double[][] centers) {
        this.centers = centers;
        redraw();
    }

    public void settings() {
        size(640, 640);
    }

    public void setup() {
        smooth();
        textSize(10);
        textAlign(CENTER);
        ellipseMode(CENTER);
        noLoop();
    }

    public void draw() {

        background(255);

        float horizontalOffset = this.width / 20.0f;
        float verticalOffset = this.height - this.height / 20.0f;

        float drawRangeX = this.width - this.width / 20.0f - horizontalOffset;
        float drawRangeY = verticalOffset - this.height / 20.0f;

        double[][] values = data.values;

        double maxX = Arrays.stream(values).mapToDouble(a -> a[feature1]).max().getAsDouble();
        double maxY = Arrays.stream(values).mapToDouble(a -> a[feature2]).max().getAsDouble();

        double minX = Arrays.stream(values).mapToDouble(a -> a[feature1]).min().getAsDouble();
        double minY = Arrays.stream(values).mapToDouble(a -> a[feature2]).min().getAsDouble();

        if (centers != null) {
            maxX = Math.max(maxX, Arrays.stream(centers).mapToDouble(a -> a[feature1]).max().getAsDouble());
            maxY = Math.max(maxY, Arrays.stream(centers).mapToDouble(a -> a[feature2]).max().getAsDouble());

            minX = Math.min(minX, Arrays.stream(centers).mapToDouble(a -> a[feature1]).min().getAsDouble());
            minY = Math.min(minY, Arrays.stream(centers).mapToDouble(a -> a[feature2]).min().getAsDouble());
        }

        double scaleX = drawRangeX / (maxX - minX);
        double scaleY = drawRangeY / (maxY - minY);

        strokeWeight(10);
        for (int i = 0; i < values.length; i++) {

            if (data.classification != null) {
                stroke(getColour(data.classification[i]));
            }

            point((float) (this.width / 20 + scaleX * (values[i][feature1] - minX)), verticalOffset - (float) (scaleY * (values[i][feature2] - minY)));
        }

        strokeWeight(2);


        if (centers != null) {

            for (int i = 0; i < centers.length; i++) {

                fill(getColour(i), 50);
                stroke(getColour(i), 150);
                ellipse((float) (this.width / 20 + scaleX * (centers[i][feature1] - minX)), verticalOffset - (float) (scaleY * (centers[i][feature2] - minY)), 20, 20);
            }
        }

        stroke(0);
    }

    private int getColour(int val) {
        switch (val) {
            case 0:
                return color(255, 0, 0);
            case 1:
                return color(0, 255, 0);
            case 2:
                return color(0, 0, 255);
			case 3:
				return color(0, 127, 127);
        }
        return color(0, 0, 0);
    }
}