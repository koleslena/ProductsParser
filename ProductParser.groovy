class ProductParser {
    static def parse(name, nameout) {
        def fin = new File(name)
        def fout = new File(nameout)
        if(!fout.exists()) {
            fout.createNewFile()
        }
        fout.write("")
        
        def str = """
                    <products>"""
        fin.eachLine {
             def t = it.split(' ')
             str += """
                <product name='${t[0]}'>
                    <date>${t[1]}</date>
                    <count>${t[2]}</count>
                    <price>${t[3]}</price>
                 </product>
                """.toString()
         }
         str += """</products>"""
         fout<<'<?xml version="1.0" encoding="UTF-8"?>'
         fout<<str
    }

    public static void main(String[] args){
	def nameout = 'prods.xml'
        ProductParser.parse(args[0], nameout)
        new File(nameout).eachLine{println it}
    }
}
