package rlforj.los.test;

import rlforj.los.ConePrecisePremisive;
import rlforj.los.IConeFovAlgorithm;
import rlforj.los.ShadowCasting;
import rlforj.math.Point;

public class ConeFovTest
{
    /*
     * TODO : convert to TestCase
     */
    public static void main(final String[] args)
    {
        final int startAngle  = -10;
        final int finishAngle = 100;
        //		if(startAngle<0) {startAngle%=360; startAngle+=360; }
        //		if(finishAngle<0) {finishAngle%=360; finishAngle+=360; }
        //
        //		if(startAngle>360) startAngle%=360;
        //		if(finishAngle>360) finishAngle%=360;
        //		System.out.println(startAngle+" "+finishAngle);

        final TestBoard b = new TestBoard(false);

        b.exception.add(new Point(15, 15));
        b.exception.add(new Point(15, 16));
        b.exception.add(new Point(16, 15));

        IConeFovAlgorithm a = new ConePrecisePremisive();

        a.visitConeFieldOfView(b, 10, 10, 10, startAngle, finishAngle);

        b.mark(10, 10, '@');
        b.print(-1, 21, -1, 21);

        System.out.println("visitederr " + b.visiterr);

        a = new ShadowCasting();
        b.visited.clear();

        a.visitConeFieldOfView(b, 10, 10, 10, startAngle, finishAngle);

        b.mark(10, 10, '@');
        b.print(-1, 21, -1, 21);

        //		IFovAlgorithm a1= new ShadowCasting();
        //		b.visited.clear();
        //
        //		a1.visitFieldOfView(b, 10, 10, 10);
        //
        //		b.mark(10, 10, '@');
        //		b.print(-1, 21, -1, 21);
    }
}
