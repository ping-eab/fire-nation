.model small
.stack
.code
main 		proc
		mov cx,5
		mov, ah2
		mov dl,'A'
outer:	int 21h
		push cx
		push dx
		mov cx,3
		mov dl,'*'
inner:	int 21h
		loop inner 
		pop dx
		pop cx
		add dl,2
		loop outer
		mov ah,4ch
		int 21h
main  	endp
end 	main
