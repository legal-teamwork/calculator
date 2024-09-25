using Microsoft.AspNetCore.Mvc;

namespace ServiceCalculator.Controllers
{
    public class AddExpressionInput
    {
        public string Expression { get; set; }
    }

    [ApiController]
    [Route("[controller]")]
    public class AddExpressionController : ControllerBase
    {

        private readonly ILogger<AddExpressionController> _logger;

        public AddExpressionController(ILogger<AddExpressionController> logger)
        {
            _logger = logger;
        }

        [HttpPost(Name = "AddExpressionController")]
        public ExpressionAndResult Post(AddExpressionInput expression)
        {
            ExpressionAndResult exp_and_res = new(expression.Expression);
            ListOfExpressions.List.Insert(0, exp_and_res);
            return exp_and_res;
        }
    }
}