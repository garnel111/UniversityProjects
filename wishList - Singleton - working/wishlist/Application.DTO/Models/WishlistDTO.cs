using Farfetch.wishlist.Application.DTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Farfetch.wishlist.Application.DTO
{
    public class WishlistDTO
    {
        public int ExternalId { get; set; }
        public int OwnerId { get; set; }
     //   public IEnumerable<WishlistItemDTO> Items { get; set; }
    }
}
