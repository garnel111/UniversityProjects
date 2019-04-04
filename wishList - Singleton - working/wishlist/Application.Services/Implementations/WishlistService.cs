using AutoMapper;
using Farfetch.wishlist.Application.DTO;
using Farfetch.wishlist.Application.Services.Interfaces;
using Farfetch.wishlist.Domain.Core.Interface;
using Farfetch.wishlist.Domain.Model;
using System;
using System.Collections.Generic;

namespace Farfetch.wishlist.Application.Services.Implementations
{
    public class WishlistService : IWishlistService
    {
        private IWishlistRepository wishlistRepository;

        public WishlistService(IWishlistRepository itemRepository)
        {
            wishlistRepository = itemRepository;
        }

        public Wishlist AddWishlist(WishlistDTO wishlistDTO)
        {
            Wishlist wishlist = Mapper.Map<WishlistDTO, Wishlist>(wishlistDTO);
            wishlistRepository.AddWishlist(wishlist);
            return null;

        }


        //public IEnumerable<WishlistDTO> GetAll()
        //{
        //    var result = wishlistRepository.GetAll();
        //    return Mapper.Map<IEnumerable<Wishlist>, IEnumerable<WishlistDTO>>(result);
        //}


        //devolver uma wishlist

        //public WishlistDTO GetWishlist(int id)
        //{
        //   // var wishlist = WishlistRepository.GetWishlist(id);
        //    var wishlist = wishlistRepository.GetWishlist(id);
        //    if(wishlist == null){
        //        return null;
        //    }
        //    return Mapper.Map<Wishlist, WishlistDTO>(wishlist); 
        //}

        IEnumerable<WishlistDTO> IWishlistService.GetWishlist(int id)
        {
            var wishlist = wishlistRepository.GetWishlist(id);
            if (wishlist == null)
            {
                return null;
            }
            var wishlist2 = Mapper.Map<IEnumerable<Wishlist>, IEnumerable<WishlistDTO>>(wishlist);
            return wishlist2;
        }



        //List<WishlistDTO> IWishlistService.GetWishlistList()
        //{
        //    var wlList= WishlistRepository.GetWishlistList();

        //    var iterator = wlList.GetEnumerator();
        //    //while (iterator.MoveNext())
        //    //{
        //    //    wishlist ex = iterator.Current;
        //    //    yield return Mapper.Map<wishlist, WishlistDTO>(ex);
        //    //}

        //}

        //WishlistDTO IWishlistService.GetWishlist(int wishlistID)
        // {
        //     var wishlist = wishlistRepository.GetWishlist(wishlistID);
        //     return Mapper.Map<Wishlist,WishlistDTO>(wishlist);

        // }



        //public List<WishlistDTO> GetWishlistList()
        //{
        //    var result = wishlistRepository.GetWishlistList();
        //    return Mapper.Map<List<Wishlist>, List<WishlistDTO>>(result);
        //}

        public void DeleteWishlist(int WishlistID)
        {
            throw new NotImplementedException();
        }

        IEnumerable<WishlistDTO> IWishlistService.GetAll()
        {
            var result = wishlistRepository.GetAll();
            return Mapper.Map<IEnumerable<Wishlist>, IEnumerable<WishlistDTO>>(result);
        }

       Wishlist IWishlistService.AddOrUpdateWishlist(WishlistDTO wishlistDTO)
        {
            Wishlist wishlist = Mapper.Map<WishlistDTO, Wishlist>(wishlistDTO);
            var returnObj = wishlistRepository.AddWishlist(wishlist);
            return returnObj;
        }

        public IEnumerable<WishlistDTO> GetWithSingleton()
        {
            var result = wishlistRepository.GetAll();
            return Mapper.Map<IEnumerable<Wishlist>, IEnumerable<WishlistDTO>>( result);
        }

        public Wishlist DeleteWishlist(Wishlist wlToRemove)
        {
            var result = wishlistRepository.DeleteWishlist(wlToRemove);
            return wlToRemove;
        }

        public void UpdateWishlist(Wishlist wlToUpdate)
        {
             wishlistRepository.UpdateWishlist(wlToUpdate);
        }

        //public IEnumerable<WishlistDTO> GetWithSingleton()
        //{
        //    var result = wishlistRepository.GetAll();
        //  IEnumerable<Wishlist> wishlistList = Mapper.Map<IEnumerable<Wishlist>, IEnumerable<WishlistDTO>>(result);
        //    return wishlistList;
        //}

        //public Wishlist AddOrUpdateWishlist(WishlistDTO wishlistDTO)
        //{
        //    Wishlist wishlist = Mapper.Map<WishlistDTO, Wishlist>(wishlistDTO);
        //    var returnObj = wishlistRepository.AddOrUpdateWishlist(wishlist);

        //}


    }
}
