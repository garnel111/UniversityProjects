using System;
using System.Collections.Generic;
using System.Diagnostics.CodeAnalysis;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Farfetch.wishlist.Infrastructure.CrossCutting.Adapters
{
    [ExcludeFromCodeCoverage]
    public static class TypeAdapterHelper
    {
        public static TTarget Adapt<TSource, TTarget>(TSource source)
           where TTarget : class
           where TSource : class
        {
            return TypeAdapterFactory.CreateAdapter().Adapt<TSource, TTarget>(source);
        }

        public static TTarget Adapt<TTarget>(object source)
           where TTarget : class
        {
            return TypeAdapterFactory.CreateAdapter().Adapt<TTarget>(source);
        }

        public static TTarget Map<TSource, TTarget>(TSource source, TTarget target)
            where TTarget : class
            where TSource : class
        {
            return TypeAdapterFactory.CreateAdapter().Map(source, target);
        }
    }






}
