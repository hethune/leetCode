class Solution:
    # @return an integer
    def divide(self, dividend, divisor):
        if divisor == 0:
            return float('nan')
        if divisor == 1:
            return dividend
        if divisor == -1:
            return -dividend
        sign = 1 if (dividend > 0 and divisor > 0) or (dividend < 0 and divisor <0) else -1
        dividend = abs(dividend)
        divisor = abs(divisor)
        if dividend == divisor:
            return sign
        val = 0
        while dividend >= divisor:
            counter = 0
            divisor_new = divisor
            while divisor_new <= dividend:
                divisor_new <<= 1
                counter += 1
            divisor_new >>= 1
            counter -= 1
            val += 1 << counter
            dividend -= divisor_new
            if dividend < divisor:
                break
        return val if sign ==1 else -val