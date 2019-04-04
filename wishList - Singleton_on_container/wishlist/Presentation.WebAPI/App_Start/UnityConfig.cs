
using Farfetch.wishlist.Application.Services.Implementations;
using Farfetch.wishlist.Application.Services.Interfaces;
using Farfetch.wishlist.Data.Repository;
 
using Farfetch.wishlist.Domain.Core.Interface;
using System;
using Unity;

namespace Presentation.WebAPI
{
    /// <summary>
    /// Specifies the Unity configuration for the main container.
    /// </summary>


    public static class UnityConfig
    {


        static string source = "dummy";
        //static string source = "database";


        #region Unity Container


        private static Lazy<IUnityContainer> container =
      new Lazy<IUnityContainer>(() =>
      {
          var container = new UnityContainer();
          RegisterTypes(container, source);
          return container;
      });

        /// <summary>
        /// Configured Unity Container.
        /// </summary>
        public static IUnityContainer Container => container.Value;
        #endregion

        /// <summary>
        /// Registers the type mappings with the Unity container.
        /// </summary>
        /// <param name="container">The unity container to configure.</param>
        /// <remarks>
        /// There is no need to register concrete types such as controllers or
        /// API controllers (unless you want to change the defaults), as Unity
        /// allows resolving a concrete type even if it was not previously
        /// registered.
        /// </remarks>
        public static void RegisterTypes(IUnityContainer container, string sourceCode)
        {
            // NOTE: To load from web.config uncomment the line below.
            // Make sure to add a Unity.Configuration to the using statements.
            // container.LoadConfiguration();

            // TODO: Register your type's mappings here.
          

            container.RegisterType<IWishlistService, WishlistService>();
            container.RegisterType<IOwnerService, OwnerService>();
            container.RegisterType<IOwnerRepository, OwnerRepository>();
            container.RegisterType<IConnectionFactory, ConnectionFactory>();

            if (sourceCode.Equals("database"))
            {
                container.RegisterType<IWishlistRepository, WishlistRepository>();
            }
           else if (sourceCode.Equals("dummy"))
            {
               container.RegisterSingleton<IWishlistRepository, Farfetch.wishlist.Data.Repository.Implementations.WishlistDummyRepository>();

            }
        }
        
    }

}