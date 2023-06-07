import java.util.ArrayList;

public class CalculusExamples {

    // (y^(0.5)*x^(1.5) + y^(2.2)*x^(-0.7))^(-2.6)
    public static FunctionExpression equationExample1(){
        FunctionExpression Q1=FunctionExpression.exp(new Function("y","y",0),0.5);
        FunctionExpression Q2=FunctionExpression.exp(new Function("x","x",0),1.5);
        Q1=FunctionExpression.product(Q1, Q2);

        FunctionExpression a1=FunctionExpression.exp(new Function("y","y",0),2.2);
        FunctionExpression a2=FunctionExpression.exp(new Function("x","x",0),-0.7);
        a1=FunctionExpression.product(a1, a2);
        a1=FunctionExpression.sum(Q1, a1);
        return FunctionExpression.exp(a1, -2.6);
    }

    public static FunctionExpression Przyklad1(){
        FunctionExpression Q1 = FunctionExpression.exp(new Function("x","x",0),2.0);
        FunctionExpression Q2 = FunctionExpression.exp(new Function("y","y",0),2.0);

        FunctionExpression Q3 = FunctionExpression.product(new Function("x","x",0.0),
                2.0);
        Q3 = FunctionExpression.sum(Q3,new Function("y","y",0));
        Q3= FunctionExpression.sub(Q3,2.0);
        Q3 = FunctionExpression.product(new Function("z","z",0),Q3);
        FunctionExpression Q4 = FunctionExpression.sum(Q1,Q2);
        Q4 = FunctionExpression.sum(Q4,Q3);
        return Q4;
    }


    // (ln(y)^(0.5)*ln(x)^(1.5) + ln(y)^(2.2)*ln(x)^(-0.7))^(-2.6)
    public static FunctionExpression equationExample2(){
        FunctionExpression Q1=FunctionExpression.exp(new Function("ln","y",0),0.5);
        FunctionExpression Q2=FunctionExpression.exp(new Function("ln","x",0),1.5);
        Q1=FunctionExpression.product(Q1, Q2);

        FunctionExpression a1=FunctionExpression.exp(new Function("ln","y",0),2.2);
        FunctionExpression a2=FunctionExpression.exp(new Function("ln","x",0),-0.7);
        a1=FunctionExpression.product(a1, a2);
        a1=FunctionExpression.sum(Q1, a1);
        return FunctionExpression.exp(a1, -2.6);
    }
    // ((ln(y)^(0.5)*ln(x)^(1.5) + ln(y)^(2.2)*ln(x)^(-0.7))^(-2.6) + (y^(0.5)*x^(1.5) + y^(2.2)*x^(-0.7))^(-2.6) )^(4.2)
    public static FunctionExpression equationExample3(){
        FunctionExpression a= FunctionExpression.sum(equationExample1(),equationExample2());
        return FunctionExpression.exp(a,4.2);
    }
    //sin(cos( (y^(0.5)*x^(1.5) + y^(2.2)*x^(-0.7))^(-2.6) )^(-2.5))
    public static FunctionExpression equationExample4(){
        Function s=new Function("cos", "~", 0);
        FunctionExpression Q1=FunctionExpression.exp(new Function("y","y",0),0.5);
        FunctionExpression Q2=FunctionExpression.exp(new Function("x","x",0),1.5);
        Q1=FunctionExpression.product(Q1, Q2);
        s.compose=equationExample1();
        FunctionExpression a=FunctionExpression.exp(s, -2.5);
        Function d=new Function("sin", "~", 0);
        d.compose=a;
        return new FunctionExpression(d);
    }
    // (y^(2.3)+x^(4.1))(y^(1.9)+x^(-4.7))
    public static FunctionExpression equationExample5(){
        FunctionExpression Q1=FunctionExpression.exp(new Function("y","y",0),2.3);
        FunctionExpression Q2=FunctionExpression.exp(new Function("x","x",0),4.1);
        Q1=FunctionExpression.sum(Q1, Q2);

        FunctionExpression a1=FunctionExpression.exp(new Function("y","y",0),1.9);
        FunctionExpression a2=FunctionExpression.exp(new Function("x","x",0),-4.7);
        a1=FunctionExpression.sum(a1, a2);
        a1=FunctionExpression.product(Q1, a1);
        return a1;
    }
    // sin( sin(cos( (y^(0.5)*x^(1.5) + y^(2.2)*x^(-0.7))^(-2.6) )^(-2.5) ) + cos((y^(2.3)+x^(4.1))(y^(1.9)+x^(-4.7))) )
    public static FunctionExpression equationExample6(){
        Function d=new Function("cos", "~", 0);
        d.compose=equationExample5();
        FunctionExpression t=FunctionExpression.sum(equationExample4(), d);
        Function e=new Function("sin", "~", 0);
        e.compose=t;
        return new FunctionExpression(e);
    }


    public static void derivativeExample(FunctionExpression functionExpression){
        //define variables that will be used
        ArrayList<String> variables=new ArrayList<String>();
        ArrayList<Double> values=new ArrayList<Double>();
        values.add(0.8);
        variables.add("x");
        values.add(0.4);
        variables.add("y");
        values.add(-0.8);
        variables.add("z");

        //machine that handles computations
        Calculus.setVariables(variables);
        Calculus.setValues(values);

        FunctionExpression f=functionExpression;
        //simplyfing the expression
        f=FunctionExpression.simplifyExpression(f);
        //printing the expression tree, by level
        //f.printByLevel();
        //f evaluated at specified point

        //computing the first derivative od f, with respect to x
        FunctionExpression firstDerivativeX=Calculus.computeDerivative("x", f);
        macierzZeWspolczynnikami[0][0] = firstDerivativeX.right.right.function.value;macierzZeWspolczynnikami[0][1] = firstDerivativeX.left.left.function.value;
        macierzZeWspolczynnikami[0][2] =firstDerivativeX.left.right.function.value;macierzZeWspolczynnikami[0][3] =firstDerivativeX.left.left.function.value;
        if(firstDerivativeX!=null){
            firstDerivativeX=FunctionExpression.simplifyExpression(firstDerivativeX);
//            firstDerivativeX.printByLevel();
            System.out.println("First derivative d/dx\n"+Calculus.compute(firstDerivativeX)+"\n");
        }


        //computing the first derivative od f, with respect to x
        FunctionExpression firstDerivativeY=Calculus.computeDerivative("y", f);
        macierzZeWspolczynnikami[1][1] = firstDerivativeY.left.right.function.value;macierzZeWspolczynnikami[1][2] =1.0;
        macierzZeWspolczynnikami[1][0] = firstDerivativeY.left.left.function.value;macierzZeWspolczynnikami[1][3] =firstDerivativeY.left.left.function.value;
        if(firstDerivativeY!=null){
            firstDerivativeY=FunctionExpression.simplifyExpression(firstDerivativeY);
//            firstDerivativeY.printByLevel();
            System.out.println("First derivative d/dy\n"+Calculus.compute(firstDerivativeY)+"\n");
        }

        FunctionExpression firstDerivativeZ=Calculus.computeDerivative("z", f);
        macierzZeWspolczynnikami[2][0] = firstDerivativeZ.left.left.right.function.value;macierzZeWspolczynnikami[2][3] =firstDerivativeZ.right.function.value;
        macierzZeWspolczynnikami[2][1] = 1; macierzZeWspolczynnikami[2][2] =firstDerivativeZ.left.left.left.function.value;
        if(firstDerivativeZ!=null){
            firstDerivativeZ=FunctionExpression.simplifyExpression(firstDerivativeZ);
//            firstDerivativeZ.printByLevel();
            System.out.println("First derivative d/dz\n"+Calculus.compute(firstDerivativeZ)+"\n");
        }
    }

    public static FunctionExpression equationExample7(){
        ArrayList<Double> startPoint=new ArrayList<Double>();
        ArrayList<String> variables=new ArrayList<String>();
        startPoint.add(18.0);
        variables.add("x");
        startPoint.add(25.0);
        variables.add("y");
        Calculus.setVariables(variables);
        FunctionExpression f=FunctionExpression.exp(new Function("y","y",0),3.0);
        //f=FunctionExpression.product(f, new Function("x", "x", 0));
        FunctionExpression f2=FunctionExpression.exp(new Function("x","x",0),3.0);
        //f2=FunctionExpression.product(f2, new Function("y", "y", 0));
        FunctionExpression f3=FunctionExpression.product(new Function("y","y",0), new Function("x","x",0));
        f=FunctionExpression.sum(f, f2);
        f=FunctionExpression.sum(f, f3);
        //f.printByLevel();
        return f;
    }

    public static FunctionExpression equationExample8(){
        FunctionExpression temp =FunctionExpression.div(equationExample7(), FunctionExpression.exp(new Function("x","x",0),3.0));
        return FunctionExpression.div(temp,equationExample1());
    }

    public static void derivativesExample(){
        ArrayList<Double> startPoint=new ArrayList<Double>();
        ArrayList<String> variables=new ArrayList<String>();
        startPoint.add(-350.0);
        variables.add("x");
        startPoint.add(-250.0);
        variables.add("y");
        Calculus.setVariables(variables);
        Calculus.setValues(startPoint);
        //trasforms the function, ensuring a convex space for optimization
        FunctionExpression functionExpression=Calculus.lengthOfGradient(equationExample7());
        ArrayList<FunctionExpression> derivatives=Calculus.getDerivatives(functionExpression);


        ArrayList<FunctionExpression> secondDerivativesByX=Calculus.getDerivatives(derivatives.get(0));
        ArrayList<FunctionExpression> secondDerivativesByY=Calculus.getDerivatives(derivatives.get(1));
        System.out.println("d/dx :"+Calculus.compute(derivatives.get(0)));
        System.out.println("d/dy :"+Calculus.compute(derivatives.get(1)));
        System.out.println("\nd(d/dx)/dx :"+Calculus.compute(secondDerivativesByX.get(0)));
        System.out.println("d(d/dy)/dy :"+Calculus.compute(secondDerivativesByY.get(1)));
        System.out.println("\nd(d/dx)/dy :"+Calculus.compute(secondDerivativesByX.get(1)));
        System.out.println("d(d/dy)/dx :"+Calculus.compute(secondDerivativesByY.get(0)));

        ArrayList<Double> d=GradientDescent.descent(startPoint, functionExpression);

        for(int i=0;i<d.size();i++){
            System.out.println(d.get(i));
        }
    }
    static double[][] macierzZeWspolczynnikami = new double[3][4];


}
