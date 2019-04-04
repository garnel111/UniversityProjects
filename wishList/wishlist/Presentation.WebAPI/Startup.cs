using Microsoft.Owin;
using Owin;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

[assembly: OwinStartup(typeof(Presentation.WebAPI.Startup))]

namespace Presentation.WebAPI
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {

        }
    }
}