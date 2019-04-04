using Farfetch.wishlist.Application.DTO;
using Farfetch.wishlist.Application.Services.Interfaces;
using Farfetch.wishlist.Data.Repository.DummyData;
using Farfetch.wishlist.Domain.Model;
using System.Collections.Generic;
using System.Threading.Tasks;
using System.Web.Http;

namespace Presentation.WebAPI.Controllers.Version1
{
    [RoutePrefix("v1")]
    public class WishlistController : ApiController
    {
        
        private IWishlistService wishlistService;
       
       
        public WishlistController(IWishlistService WishlistService )
        {
            this.wishlistService = WishlistService;
          
        }


        //// GET v1/
        //[Route("")]
        //public IHttpActionResult Get()
        //{
        //    var result = wishlistService.GetAll();
        //    return this.Ok(result);
        //}

        // GET v1/
        [Route("")]
        public IHttpActionResult Get()
        {
             var result = wishlistService.GetWithSingleton();
  
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

        //Post
        [Route("Wishlist")]
       // [Route("{id:int}")]
        public IHttpActionResult Post(WishlistDTO wishlist)
        {

            wishlistService.AddOrUpdateWishlist(wishlist);
            return Ok(wishlist);
        
        }

        // Put v1/{id}
        [Route("{id:int}")]
        public IHttpActionResult PutWishlist(Wishlist wlToUpdate)
        {
            wishlistService.UpdateWishlist(wlToUpdate);
            return Ok("Instance was updated.");
        }

        // DELETE v1/{id}
        [Route("{id:int}")]
        public IHttpActionResult DeleteWishlist(Wishlist wlToRemove)
        {
             wishlistService.DeleteWishlist(wlToRemove);
            return Ok("Instance was deleted.");
        }



        //// GET v1/owner/{id}
        //[Route("{id:int}")]
        //public IHttpActionResult GetOwnerWishlistById(int id)
        //{
        //    var returnDTO = wishlistService.GetAll(id);
        //    var owner = returnDTO. 
        //    if (returnDTO == null)
        //    {
        //        return NotFound();
        //    }

        //    return this.Ok(returnDTO);
        //}
    }
}
