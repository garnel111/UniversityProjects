using Farfetch.wishlist.Application.Services.Interfaces;
using System.Threading.Tasks;
using System.Web.Http;

namespace Presentation.WebAPI.Controllers.Version1
{
    [RoutePrefix("v1")]
    public class WishlistController : ApiController
    {
        
        private IWishlistService wishlistService;
        public WishlistController()
        {

        }
        public WishlistController(IWishlistService wishlistService)
        {
            this.wishlistService = wishlistService;
        }


        // GET v1/
        [Route("")]
        public IHttpActionResult Get()
        {
            var result = wishlistService.GetAll();
            return this.Ok(result);
        }

        // GET v1/{id}
        [Route("{id:int}")]
        public IHttpActionResult Get(int id)
        {
            var returnDTO = wishlistService.GetWishlist(id);

            if (returnDTO == null)
            {
                return NotFound();
            }

            return this.Ok(returnDTO);
        }

        //// GET v1/owner/{id}
        //[Route("{id:int}")]
        //public IHttpActionResult GetOwnerWishlistById(int id)
        //{
        //    var returnDTO = wishlistService.GetWishlist(id);
        //    var owner = returnDTO. 
        //    if (returnDTO == null)
        //    {
        //        return NotFound();
        //    }

        //    return this.Ok(returnDTO);
        //}
    }
}
