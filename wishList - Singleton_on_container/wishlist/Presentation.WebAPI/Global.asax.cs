using Farfetch.wishlist.Application.Services.TypeAdapters;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web.Http;

namespace Presentation.WebAPI
{
    public class WebApiApplication : System.Web.HttpApplication
    {
        protected void Application_Start()
        {
            GlobalConfiguration.Configure(WebApiConfig.Register);
            MapperConfig.Configure();
        }
    }
}
