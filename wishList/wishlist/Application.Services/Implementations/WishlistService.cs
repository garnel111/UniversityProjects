using AutoMapper;
using Farfetch.wishlist.Application.DTO;
using Farfetch.wishlist.Application.Services.Interfaces;
using Farfetch.wishlist.Data.Repository;
using Farfetch.wishlist.Domain.Core.Interface;
using Farfetch.wishlist.Domain.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Farfetch.wishlist.Application.Services.Implementations
{
    public class WishlistService : IWishlistService
    {
        private IWishlistRepository wishlistRepository;
       
        public WishlistService(IWishlistRepository itemRepository)
        {
            wishlistRepository = itemRepository;
        }

        public WishlistDTO AddWishlist(WishlistDTO wishlistDTO)
        {
            throw new NotImplementedException();
        }

        public void DeleteWishlist(int wishlistID)
        {
            throw new NotImplementedException();
        }

        public List<WishlistDTO> GetAll()
        {
            var result = wishlistRepository.GetWishlistList();
            return Mapper.Map<List<Wishlist>,List<WishlistDTO>>(result);
        }


        //devolver uma Wishlist

        public WishlistDTO GetWishlist(int id)
        {
            var wishList = wishlistRepository.GetWishlist( id);
            if(wishList == null){
                return null;
            }
            return Mapper.Map<Wishlist, WishlistDTO>(wishList);
        }

        public WishlistDTO GetWishlist()
        {
            throw new NotImplementedException();
        }

        public WishlistDTO GetWishlistA(int wishlistID)
        {
            throw new NotImplementedException();
        }

        //List<WishlistDTO> IWishlistService.GetWishlistList()
        //{
        //    var wlList= wishlistRepository.GetWishlistList();

        //    var iterator = wlList.GetEnumerator();
        //    //while (iterator.MoveNext())
        //    //{
        //    //    Wishlist ex = iterator.Current;
        //    //    yield return Mapper.Map<Wishlist, WishlistDTO>(ex);
        //    //}
        
        //}

        IEnumerable<WishlistDTO> IWishlistService.GetWishlist(int wishlistID)
        {
            var wishList = wishlistRepository.GetWishlist(wishlistID);
            yield return Mapper.Map<Wishlist, WishlistDTO>(wishList);
        }

        

        public List<WishlistDTO> GetWishlistList()
        {
            throw new NotImplementedException();
        }
    }
}
