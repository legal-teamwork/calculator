namespace Tests
{
    public class Tests
    {
        Calculator calculator;

        [SetUp]
        public void Setup()
        {
            calculator = new Calculator();
        }

        [Test]
        public void CorrectInput()
        {
            Assert.That(calculator.Calculate("1+2"), Is.EqualTo(3));
            Assert.That(calculator.Calculate("3*2"), Is.EqualTo(6));
            Assert.That(calculator.Calculate("3/2"), Is.EqualTo(1.5));
            Assert.That(calculator.Calculate("1+2+3"), Is.EqualTo(6));
            Assert.That(calculator.Calculate("5-2-1"), Is.EqualTo(2));
            Assert.That(calculator.Calculate("4*3*2"), Is.EqualTo(24));
            Assert.That(calculator.Calculate("12/3/2"), Is.EqualTo(2.0));

            Assert.That(calculator.Calculate("1-2"), Is.EqualTo(-1));
            Assert.That(calculator.Calculate("3*(-2)"), Is.EqualTo(-6));
            Assert.That(calculator.Calculate("3/(-2)"), Is.EqualTo(-1.5));


            Assert.That(calculator.Calculate("-(1+2)"), Is.EqualTo(-3));
            Assert.That(calculator.Calculate("(1+2)-(1+2)"), Is.EqualTo(0));
            Assert.That(calculator.Calculate("-((1+2)-(3+2))"), Is.EqualTo(2));
            Assert.That(calculator.Calculate("1+(2)"), Is.EqualTo(3));
            Assert.That(calculator.Calculate("1+(-2)"), Is.EqualTo(-1));

            Assert.That(calculator.Calculate("+1+1"), Is.EqualTo(2));
            Assert.That(calculator.Calculate("+1-1"), Is.EqualTo(0));
            Assert.That(calculator.Calculate("1"), Is.EqualTo(1));
            Assert.That(calculator.Calculate("+1"), Is.EqualTo(1));
            Assert.That(calculator.Calculate("-1"), Is.EqualTo(-1));
            Assert.That(calculator.Calculate("(1)"), Is.EqualTo(1));
            Assert.That(calculator.Calculate("(+1)"), Is.EqualTo(1));
            Assert.That(calculator.Calculate("(-1)"), Is.EqualTo(-1));
            Assert.That(calculator.Calculate("((1))"), Is.EqualTo(1));
            Assert.That(calculator.Calculate("(+(-1))"), Is.EqualTo(-1));
            Assert.That(calculator.Calculate("(-(+1))"), Is.EqualTo(-1));
            Assert.That(calculator.Calculate("(-(-1))"), Is.EqualTo(1));
            Assert.That(calculator.Calculate("-(-(-1))"), Is.EqualTo(-1));
            Assert.That(calculator.Calculate("(((((((-1)))))))"), Is.EqualTo(-1));

        }

        [Test]
        public void IncorrectInput()
        {
            Assert.Throws<ArgumentException>(() => { calculator.Calculate("+"); });
            Assert.Throws<ArgumentException>(() => { calculator.Calculate("-"); });
            Assert.Throws<ArgumentException>(() => { calculator.Calculate("*"); });
            Assert.Throws<ArgumentException>(() => { calculator.Calculate("/"); });
            Assert.Throws<ArgumentException>(() => { calculator.Calculate("1+"); });
            Assert.Throws<ArgumentException>(() => { calculator.Calculate("1-"); });
            Assert.Throws<ArgumentException>(() => { calculator.Calculate("1*"); });
            Assert.Throws<ArgumentException>(() => { calculator.Calculate("1/"); });
            Assert.Throws<ArgumentException>(() => { calculator.Calculate("1+1+"); });
            Assert.Throws<ArgumentException>(() => { calculator.Calculate("+1+1+"); });


            Assert.Throws<ArgumentException>(() => { calculator.Calculate("()"); });
            Assert.Throws<ArgumentException>(() => { calculator.Calculate("(+)"); });
            Assert.Throws<ArgumentException>(() => { calculator.Calculate("(-)"); });
            Assert.Throws<ArgumentException>(() => { calculator.Calculate("(*)"); });
            Assert.Throws<ArgumentException>(() => { calculator.Calculate("(/)"); });

            Assert.Throws<ArgumentException>(() => { calculator.Calculate("("); });
            Assert.Throws<ArgumentException>(() => { calculator.Calculate(")"); });
            Assert.Throws<ArgumentException>(() => { calculator.Calculate("((1+1)"); });
            Assert.Throws<ArgumentException>(() => { calculator.Calculate("(1+1))"); });
            Assert.Throws<ArgumentException>(() => { calculator.Calculate(")1+1"); });
            Assert.Throws<ArgumentException>(() => { calculator.Calculate("(1+1"); });
            Assert.Throws<ArgumentException>(() => { calculator.Calculate("1(+1)"); });
            Assert.Throws<ArgumentException>(() => { calculator.Calculate("-1+()1+1"); });
            Assert.Throws<ArgumentException>(() => { calculator.Calculate("(((((((-1))))))"); });
            Assert.Throws<ArgumentException>(() => { calculator.Calculate("3*-2"); });
            Assert.Throws<ArgumentException>(() => { calculator.Calculate("3/-2"); });
            Assert.Throws<ArgumentException>(() => { calculator.Calculate("3--2"); });
        }
    }
}
