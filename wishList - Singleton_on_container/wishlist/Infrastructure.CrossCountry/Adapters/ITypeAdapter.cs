using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Farfetch.wishlist.Infrastructure.CrossCountry.Adapters
{
   public  interface ITypeAdapter
    {
        /// <summary>
        /// Adapt a source object to an instance of type <c>"TTarget"</c>/>
        /// </summary>
        /// <typeparam name="TSource">Type of source item</typeparam>
        /// <typeparam name="TTarget">Type of target item</typeparam>
        /// <param name="source">Instance to adapt</param>
        /// <returns><paramref name="source"/> <typeparamref name="TTarget"/>mapped to </returns>
        TTarget Adapt<TSource, TTarget>(TSource source)
            where TTarget : class
            where TSource : class;

        /// <summary>
        /// Adapt a source object to an instnace of type <c>"TTarget"</c>/>
        /// </summary>
        /// <typeparam name="TTarget">Type of target item</typeparam>
        /// <param name="source">Instance to adapt</param>
        /// <returns><paramref name="source"/> mapped to <typeparamref name="TTarget"/>mapped to </returns>
        TTarget Adapt<TTarget>(object source)
            where TTarget : class;

        TTarget Map<TSource, TTarget>(TSource source, TTarget target)
            where TTarget : class
            where TSource : class;
    }
}

