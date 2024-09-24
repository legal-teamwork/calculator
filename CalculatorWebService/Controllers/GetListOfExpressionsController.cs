using Microsoft.AspNetCore.Mvc;

namespace ServiceCalculator.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class GetListOfExpressionsController: ControllerBase
    {

        private readonly ILogger<GetListOfExpressionsController> _logger;

        public GetListOfExpressionsController(ILogger<GetListOfExpressionsController> logger)
        {
            _logger = logger;
        }

        [HttpGet(Name = "GetListOfExpressionAndResult")]
        public IEnumerable<ExpressionAndResult> Get()
        {
            return ListOfExpressions.List;
        }
    }
}
