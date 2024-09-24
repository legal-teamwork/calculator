using Microsoft.AspNetCore.Mvc;

namespace ServiceCalculator.Controllers
{
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
        public IActionResult Post(ExpressionAndResult exp_and_res)
        {
            ListOfExpressions.List.Insert(0, exp_and_res);
            return StatusCode(200);
        }
    }
}