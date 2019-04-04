using Farfetch.wishlist.Application.Services.Implementations;
using Farfetch.wishlist.Application.Services.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Presentation.WebAPI.Controllers.Version1
{
    public class OwnerController : ApiController
    {
        IOwnerService ownerService;
        public OwnerController(IOwnerService ownerService)
        {
            this.ownerService = ownerService;
        }

        // GET v1/
        [Route("")]
        public IHttpActionResult GetWishlists(int id)
        {
            var result = ownerService.GetWishlists(id);
            return this.Ok(result);
        }

    }
}
