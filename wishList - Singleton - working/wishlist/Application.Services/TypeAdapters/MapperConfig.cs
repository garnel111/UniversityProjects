using AutoMapper;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Farfetch.wishlist.Application.Services.TypeAdapters
{
    public class MapperConfig
    {
        public static void Configure()
        {
            //problem: automapper already initialized
            //solution: Use reflection to initialize
            //solution: Put this responsability on Infrastructure layer
            Mapper.Reset();
            Mapper.Initialize(x =>
            {
                x.AddProfile<WishlistProfile>();
            });
            Mapper.Configuration.AssertConfigurationIsValid();
            //var config = new MapperConfiguration(cfg =>
            //{
            //    cfg.AddProfile<ReturnProfile>();
            //});
            //return config;
        }
    }
}
