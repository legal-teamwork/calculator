using System.Linq.Expressions;

namespace ServiceCalculator
{
    public class ExpressionAndResult
    {
        public String Expression {  get; set; }
        public String Result { get; set; }


        public ExpressionAndResult(String expression)
        {
            string result = expression + " (but result)"; // here we get result from parser
            Expression = expression;
            Result = result;
        }
    }
}
